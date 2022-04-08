import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int K;
    static int L;
    static int idx = 0;

    static Point[] direction = new Point[]{new Point(0, 1), new Point(1, 0), new Point(0, -1), new Point(-1, 0)};

    static int[][] board;
    static List<Point> snake = new LinkedList<>();
    static Map<Integer, String> timeTable = new HashMap<>();

    static int time = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];

        K = Integer.parseInt(br.readLine());

        /**
         * 사과가 존재하는 board 초기화
         */
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        L = Integer.parseInt(br.readLine());
        /**
         * timeTable 초기화
         */
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            timeTable.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        /**
         * snake (1,1) 시작
         */
        snake.add(new Point(1, 1));

        Point curPoint = new Point(1, 1);

        while (true) {
            time ++;
            Point nextPoint = new Point(curPoint.x + direction[idx].x, curPoint.y + direction[idx].y);

            if(check(nextPoint)) break;

            /**
             * 사과 유무 확인 후 뱀 길이 조정
             */
            if (board[nextPoint.x][nextPoint.y] == 1) {
                snake.add(nextPoint);
                board[nextPoint.x][nextPoint.y] = 0;
            }else {
                snake.add(nextPoint);
                snake.remove(0);
            }


            if(timeTable.containsKey(time)) {
                String dir = timeTable.get(time);
                if (dir.equals("D")) {
                    idx ++;
                    if (idx == 4){
                        idx = 0;
                    }
                } else {
                    idx --;
                    if(idx == -1) {
                        idx = 3;
                    }
                }
            }
            curPoint = nextPoint;

        }
        System.out.println(time);

    }

    private static boolean check(Point nextPoint) {

        /**
         * 벽에 부딪히는 경우
         */
        if (nextPoint.x <= 0 || nextPoint.y <= 0 || nextPoint.x > N || nextPoint.y > N)
            return true;

        /**
         * 뱀 본인한테 부딪히는 경우
         */
        for (int i = 0; i < snake.size(); i++) {
            if(nextPoint.x == snake.get(i).x && nextPoint.y == snake.get(i).y)
                return true;
        }
        return false;

    }
}
