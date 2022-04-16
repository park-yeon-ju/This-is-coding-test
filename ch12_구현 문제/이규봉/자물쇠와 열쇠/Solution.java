class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int paddingsize = lock.length - 1;

        for (int d = 0; d < 4; ++d) {
            int[][] rotatedKey = rotate(d, key);
            int[][] paddedKey = pad(rotatedKey, paddingsize);

            for (int i = 0; i < paddedKey.length - paddingsize; ++i) {
                for (int j = 0; j < paddedKey[0].length - paddingsize; ++j) {
                    boolean answer = true;

                    for (int row = 0; row < lock.length; ++row) {
                        for (int col = 0; col < lock[0].length; ++col) {
                            if (lock[row][col] == paddedKey[i + row][j + col]) {
                                answer = false;
                            }
                        }
                    }

                    if (answer) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int[][] pad(int[][] arr, int size) {
        int[][] result = new int[arr.length + size * 2][arr[0].length + size * 2];

        for (int r = 0; r < arr.length; ++r) {
            for (int c = 0; c < arr[0].length; ++c) {
                result[r + size][c + size] = arr[r][c];
            }
        }

        return result;
    }

    private int[][] rotate(int cnt, int[][] arr) {
        if (cnt == 0) {
            return arr;
        }

        int[][] result = null;
        int[][] origin = copy(arr);

        for (int i = 0; i < cnt; ++i) {
            result = new int[arr.length][arr[0].length];

            for (int r = 0; r < origin.length; ++r) {
                for (int c = 0; c < origin[0].length; ++c) {
                    result[c][origin.length - 1 - r] = origin[r][c];
                }

            }
            origin = result;
        }

        return result;
    }

    private int[][] copy(int[][] arr) {
        int[][] result = new int[arr.length][arr[0].length];

        for (int r = 0; r < arr.length; ++r) {
            for (int c = 0; c < arr[r].length; ++c) {
                result[r][c] = arr[r][c];
            }
        }

        return result;
    }
}