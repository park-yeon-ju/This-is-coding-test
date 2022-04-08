import java.io.IOException;

public class Main {

    static boolean[][] pillar; // 기둥
    static boolean[][] bar; // 보

    public static int[][] solution(int n, int[][] build_frame) {

        pillar = new boolean[n + 1][n + 1];
        bar = new boolean[n + 1][n + 1];
        int count = 0;

        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int a = build[2];
            int b = build[3];

            // 기둥
            if (a == 0) {
                // 설치
                if (b == 1) {
                    if (checkPillar(x, y)) {
                        pillar[x][y] = true;
                        count++;
                    }
                    // 삭제
                } else {
                    pillar[x][y] = false;
                    if (canDelete(x, y) == false) {
                        pillar[x][y] = true;
                    } else {
                        count--;
                    }
                }
            }
            // 보
            else {
                if (b == 1) {

                    if (x == 1 && y == 1) {
                    }
                    if (checkBar(x, y)) {
                        bar[x][y] = true;
                        count++;
                    }
                    // 삭제
                } else {
                    bar[x][y] = false;
                    if (canDelete(x, y) == false) {
                        bar[x][y] = true;

                    } else {
                        count--;

                    }
                }
            }
        }


        int[][] answer = new int[count][3];

        count = 0;

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (pillar[i][j]) {
                    answer[count][0] = i;
                    answer[count][1] = j;
                    answer[count++][2] = 0;
                }
                if (bar[i][j]) {
                    answer[count][0] = i;
                    answer[count][1] = j;
                    answer[count++][2] = 1;
                }
            }
        }
        return answer;
    }

    private static boolean canDelete(int x, int y) {

        for (int i = Math.max(0, x - 1); i <= x + 1; i++) {
            for (int j = 0; j <= y + 1; j++) {
                if (pillar[i][j] && checkPillar(i, j) == false) {
                    return false;
                }
                if (bar[i][j] && checkBar(i, j) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkPillar(int x, int y) {

        if (y == 0 || (x > 0 && bar[x - 1][y]) || pillar[x][y - 1] || bar[x][y])
            return true;

        return false;

    }

    private static boolean checkBar(int x, int y) {

        if (pillar[x][y - 1] || pillar[x + 1][y - 1])
            return true;

        if (x > 0 && bar[x - 1][y] && bar[x + 1][y])
            return true;

        return false;
    }

    public static void main(String[] args) throws IOException {

//        [[0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],[2,1,1,1],[3,1,1,1],[2,0,0,0],[1,1,1,0],[2,2,0,1]]
        int[][] build_frame
                = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1},
                {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};

//                = {
//                {1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1},
//                {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        int[][] solution = solution(5, build_frame);


        for (int[] ints : solution) {
            System.out.print(ints[0] + " " + ints[1] + " " + ints[2]);
            System.out.println();
        }


    }
}
