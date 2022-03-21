import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        //그래프 초기화
        final int INF = (int) 1e9;
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                graph[i][j] = INF;
            }
        }

        //방문 여부 초기화
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            visited[i] = false;
        }

        //최단 거리 테이블 초기화
        int[] distance = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            distance[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph[x][y] = z;
        }

        distance[c] = 0;

        for (int i = 1; i < n; i++) {
            int min = INF;
            int index = -1;
            for (int j = 0; j < n + 1; j++) {
                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    index = j;
                }
            }
            if (index == -1) {
                break;
            }
            for (int j = 1; j < n + 1; j++) {
                if (!visited[j] && graph[index][j] != 0 && distance[index] + graph[index][j] < distance[j]) {
                    distance[j] = distance[index] + graph[index][j];
                }
            }
            visited[index] = true;
        }

        int cnt = 0;
        int max = 0;

        for (int j : distance) {
            if (j != INF) {
                cnt++;
                max = Math.max(j, max);
            }
        }

        System.out.println(cnt - 1 + " " + max);
    }

}