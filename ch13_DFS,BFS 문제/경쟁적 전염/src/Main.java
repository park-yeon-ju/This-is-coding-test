import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Virus implements Comparable<Virus> {

        int index;
        int second;
        int x;
        int y;

        public Virus(int index, int second, int x, int y) {
            this.index = index;
            this.second = second;
            this.x = x;
            this.y = y;
        }

        // 정렬 기준은 '번호가 낮은 순서'
        @Override
        public int compareTo(Virus other) {
            if (this.index < other.index) {
                return -1;
            }
            return 1;
        }
    }

    static int N;
    static int K;
    static int S;
    static int X;
    static int Y;
    static int[][] map = new int[200][200];

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static ArrayList<Virus> viruses = new ArrayList<Virus>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 해당 위치에 바이러스가 존재하는 경우
                if (map[i][j] != 0) {
                    // (바이러스 종류, 시간, 위치 X, 위치 Y) 삽입
                    viruses.add(new Virus(map[i][j], 0, i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        Collections.sort(viruses);
        Queue<Virus> q = new LinkedList<Virus>();
        for (int i = 0; i < viruses.size(); i++) {
            q.offer(viruses.get(i));
        }

        while (!q.isEmpty()) {
            Virus virus = q.poll();
            // 정확히 second만큼 초가 지나거나, 큐가 빌 때까지 반복
            if (virus.second == S) break;
            // 현재 노드에서 주변 4가지 위치를 각각 확인
            for (int i = 0; i < 4; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];
                // 해당 위치로 이동할 수 있는 경우
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    // 아직 방문하지 않은 위치라면, 그 위치에 바이러스 넣기
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = virus.index;
                        q.offer(new Virus(virus.index, virus.second + 1, nx, ny));
                    }
                }
            }
        }

        System.out.println(map[X-1][Y-1]);

    }
}
