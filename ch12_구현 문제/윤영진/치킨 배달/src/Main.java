import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static int N;
    static int M;

    static List<Point> house = new ArrayList<>();
    static List<Point> chicken = new ArrayList<>();

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Combination {
        int n;
        int r;
        int[] now;
        List<List<Point>> result = new ArrayList<>();

        public Combination(int n, int r) {
            this.n = n;
            this.r = r;
            now = new int[r];
        }

        public List<List<Point>> getResult() {
            return result;
        }

        public void combination(int depth, int idx, int target){

            if (depth == r) {
                List<Point> tmp = new ArrayList<>();
                for (int i = 0; i < r; i++) {
                    tmp.add(chicken.get(now[i]));
                }
                result.add(tmp);
                return;
            }
            if(target == n) return;
            now[idx] = target;

            combination(depth + 1, idx + 1, target + 1);
            combination(depth, idx, target + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                String tmp = st.nextToken();
                if (tmp.equals("1")) house.add(new Point(i, j));
                if(tmp.equals("2")) chicken.add(new Point(i, j));
            }
        }

        // nCm, n = chicken.size()
        Combination comb = new Combination(chicken.size(), M);
        comb.combination( 0, 0, 0);

        List<List<Point>> result = comb.getResult();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < result.size(); i++) {
            answer = Math.min(answer, getSum(result.get(i)));
        }

        System.out.println(answer);
    }

    private static int getSum(List<Point> candidates) {

        int answer = 0;
        for (Point h : house) {

            int tmp = Integer.MAX_VALUE;
            for (Point c : candidates) {
                tmp = Math.min(tmp, Math.abs(h.x - c.x) + Math.abs(h.y - c.y));
            }
            answer += tmp;
        }

        return answer;
    }


}