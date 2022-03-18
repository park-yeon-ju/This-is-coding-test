import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M + 1];
        int[] token = new int[N];

        arr[0] = 0;

        for (int i = 0; i < N; i++) {
            token[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i < M + 1; i++) {
            arr[i] = 10001;
        }
        for (int temp : token) {
            for (int i = 1; i <= M; i++) {
                if(i - temp < 0) continue;
                arr[i] = Math.min(arr[i], arr[i - temp] + 1);
            }
        }
        System.out.println(arr[M]);

    }

}
