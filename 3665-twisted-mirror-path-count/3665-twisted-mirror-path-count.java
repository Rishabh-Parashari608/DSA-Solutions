
class Solution {
    static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0 || grid[i][j] == 1) {
                    continue;
                }

                if (j + 1 < n) {
                    int[] pos = reflect(grid, i, j + 1, 0);

                    if (pos != null) {
                        dp[pos[0]][pos[1]] =
                            (dp[pos[0]][pos[1]] + dp[i][j]) % MOD;
                    }
                }

                if (i + 1 < m) {
                    int[] pos = reflect(grid, i + 1, j, 1);

                    if (pos != null) {
                        dp[pos[0]][pos[1]] =
                            (dp[pos[0]][pos[1]] + dp[i][j]) % MOD;
                    }
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }

    private int[] reflect(int[][] grid, int r, int c, int dir) {
        int m = grid.length;
        int n = grid[0].length;

        while (r < m && c < n && grid[r][c] == 1) {
            if (dir == 0) {
                r++;
                dir = 1;
            } else {
                c++;
                dir = 0;
            }
        }

        if (r >= m || c >= n) {
            return null;
        }

        return new int[]{r, c};
    }
}
