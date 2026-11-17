
class Solution {

    public int minimumChanges(String s, int k) {
        int n = s.length();
        int INF = 1000000000;

        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int len = j - i + 1;

                if (len < 2) {
                    cost[i][j] = INF;
                    continue;
                }

                int best = INF;

                for (int d = 1; d < len; d++) {

                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    for (int r = 0; r < d; r++) {

                        int left = i + r;
                        int right = i + r +
                                ((len - 1 - r) / d) * d;

                        while (left < right) {

                            if (s.charAt(left) !=
                                s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    best = Math.min(best, changes);
                }

                cost[i][j] = best;
            }
        }

        int[][] dp = new int[k + 1][n + 1];

        for (int p = 0; p <= k; p++) {
            java.util.Arrays.fill(dp[p], INF);
        }

        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {

            for (int i = 2 * p; i <= n; i++) {

                for (int j = 2 * (p - 1);
                     j <= i - 2; j++) {

                    if (dp[p - 1][j] == INF) {
                        continue;
                    }

                    dp[p][i] = Math.min(
                        dp[p][i],
                        dp[p - 1][j] + cost[j][i - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
