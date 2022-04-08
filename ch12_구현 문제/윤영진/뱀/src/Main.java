import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N; // 보드 크기
    static int K; // 사과 개수
    static int L; // 뱀의 방향 변환 횟수
    static int time = 0; // 게임 시간

    static int[][] board;

    static List<Point> snake = new LinkedList<>();

    static int idx = 0; // 처음 방향 오른쪽
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Map<Integer, String> dir = new HashMap<>(); // 뱀의 방향 정보

    public static class Point {
        int x;
        int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            dir.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        snake.add(new Point(1, 1));

        Point nextPoint;
        Point curPoint = new Point(1, 1);

        while (true) {
            time ++;

            nextPoint = new Point();
            nextPoint.x = curPoint.x + dx[idx];
            nextPoint.y = curPoint.y + dy[idx];

            if(End(nextPoint)) break;

            if (board[nextPoint.x][nextPoint.y] == 1) {
                board[nextPoint.x][nextPoint.y] = 0;
                snake.add(nextPoint);
            }else {
                snake.add(nextPoint);
                snake.remove(0);
            }

            curPoint = nextPoint;

            if(dir.containsKey(time)) {
                // D(오른쪽)가 다오면 index++
                if(dir.get(time).equals("D")) {
                    idx++;
                    if(idx == 4)
                        idx = 0;
                }
                // L(왼쪽)이 나오면 index--
                if(dir.get(time).equals("L")) {
                    idx--;
                    if(idx == -1)
                        idx = 3;
                }
            }
        }
        System.out.println(time);
    }

    private static boolean End(Point nextPoint) {

        if(nextPoint.x < 1 || nextPoint.y < 1 || nextPoint.x >= N +1 || nextPoint.y >= N+1)
            return true;

        for (int i = 0; i < snake.size(); i++) {
            if (nextPoint.x == snake.get(i).x && nextPoint.y == snake.get(i).y) {
                return true;
            }
        }
        return false;
    }
}
