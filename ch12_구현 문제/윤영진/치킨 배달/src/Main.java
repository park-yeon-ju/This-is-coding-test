import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

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
        public List<List<Point>> result;

        public List<List<Point>> getResult() {
            return result;
        }

        public Combination(int n, int r) {
            this.n = n;
            this.r = r;
            now = new int[r];
            result = new ArrayList<>();
        }
        
        public void combination(List<Point> chicken, int depth, int idx, int target) {

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
            combination(chicken, depth + 1, idx + 1, target + 1);
            combination(chicken, depth, idx, target + 1);

        }
    }

    private static int getSum(List<Point> house, List<Point> candidates) {

        int result = 0;
        // 모든 집에 대하여
        for (int i = 0; i < house.size(); i++) {
            int hx = house.get(i).x;
            int hy = house.get(i).y;
            // 가장 가까운 치킨 집을 찾기
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < candidates.size(); j++) {
                int cx = candidates.get(j).x;
                int cy = candidates.get(j).y;
                temp = Math.min(temp, Math.abs(hx - cx) + Math.abs(hy - cy));
            }
            // 가장 가까운 치킨 집까지의 거리를 더하기
            result += temp;
        }
        // 치킨 거리의 합 반환
        return result;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<Point> house = new ArrayList<>();
        List<Point> chicken = new ArrayList<>();

        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine()); // 0 0 1 0 0
            for (int y = 0; y < N; y++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) {
                    house.add(new Point(x, y));
                }
                if (type == 2) {
                    chicken.add(new Point(x, y));
                }
            }
        }

        Combination comb = new Combination(N, M);
        comb.combination(chicken, 0, 0, 0);
        List<List<Point>> result = comb.getResult();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < result.size(); i++) {
            answer = Math.min(answer, getSum(house,result.get(i)));
        }
        System.out.println(answer);

    }



}
