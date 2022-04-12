import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        List<Character> characters = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp < 65) {
                sum += Integer.parseInt(String.valueOf(temp));
            }else {
                characters.add(temp);
            }
        }
        Collections.sort(characters);
        for (Character c : characters) {
            System.out.print(c);
        }
        System.out.print(sum != 0 ? sum : "");
    }
}
