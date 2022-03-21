import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //회사 수
        int n = Integer.parseInt(st.nextToken());
        //경로 개수
        int m = Integer.parseInt(st.nextToken());

        //그래프 초기화
        final int INF = (int) 1e9;
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
                graph[i][j] = INF;
            }
        }

        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        floydWarshall(n, graph);

        int distance = graph[1][k] + graph[k][x];
        if (distance >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(distance);
        }

    }

    //플로이드 워셜 알고리즘
    private static void floydWarshall(int n, int[][] graph) {
        for (int k = 1; k < n + 1; k++) {
            for (int a = 1; a < n + 1; a++) {
                for (int b = 1; b < n + 1; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
    }

}
