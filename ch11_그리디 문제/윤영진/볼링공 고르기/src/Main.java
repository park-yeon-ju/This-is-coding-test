import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] weight = new int[11];

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[Integer.parseInt(st.nextToken())] += 1;
        }
        int count = 0;

        for (int i = 1; i <= M; i++) {
            N -= weight[i]; // 남은 볼링공 수
            count += weight[i] * N;
        }

        System.out.println(count);



    }


}
