import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int result_a = 0; // 0 -> 1
        int result_b = 0; // 1 -> 0

        if (S.charAt(0) == '1') {
            result_a = 1;
        } else {
            result_b = 1;
        }

        for (int i = 0; i < S.length() - 1; i++) {

            if (S.charAt(i) != S.charAt(i + 1)) {

                if (S.charAt(i + 1) == '0') {
                    result_a += 1;
                } else {
                    result_b += 1;
                }
            }
        }

        System.out.println(Math.min(result_a, result_b));


    }
}
