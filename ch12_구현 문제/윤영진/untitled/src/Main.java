import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int sum = 0;
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            // 숫자
            if (temp < 65) {
                sum += Integer.parseInt(String.valueOf(temp));
            }else {
                characters.add(temp);
            }
        }

        Collections.sort(characters);
        for (Character character : characters) {
            System.out.print(character);
        }
        System.out.print(sum != 0 ? sum : "");



    }
}
