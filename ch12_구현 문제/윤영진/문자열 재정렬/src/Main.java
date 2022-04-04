import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        List<Character> characters = new ArrayList<>();
        List<Character> nums = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) < 65) {
                nums.add(s.charAt(i));
            }else {
                characters.add(s.charAt(i));
            }
        }
        Collections.sort(characters, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return (int) o1 - (int) o2;
            }
        });

        Collections.sort(nums, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return (int) o1 - (int) o2;
            }
        });
        String result = "";
        for (int i = 0; i < characters.size(); i++) {
            result += characters.get(i);
        }
        for (int i = 0; i < nums.size(); i++) {
            result += nums.get(i);
        }
        System.out.println(result);
wo
    }
}
