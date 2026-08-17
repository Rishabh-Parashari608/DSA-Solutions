class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        int[][] dp = new int[n][n];
        int[][] bestLeft = new int[n][n];
        int[][] bestRight = new int[n][n];

        for (int i = 0; i < n; i++) {
            bestLeft[i][i] = stoneValue[i];
            bestRight[i][i] = stoneValue[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len <= n; l++) {
                int r = l + len - 1;

                int total = prefix[r + 1] - prefix[l];

                int low = l, high = r - 1;

                while (low <= high) {
                    int mid = low + (high - low) / 2;

                    int leftSum = prefix[mid + 1] - prefix[l];
                    int rightSum = total - leftSum;

                    if (leftSum <= rightSum) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                int k = high;

                if (k >= l) {
                    dp[l][r] = Math.max(
                        dp[l][r],
                        bestLeft[l][k]
                    );
                }

                if (k + 1 < r) {
                    dp[l][r] = Math.max(
                        dp[l][r],
                        bestRight[k + 2][r]
                    );
                }

                if (k >= l) {
                    int leftSum = prefix[k + 1] - prefix[l];
                    int rightSum = total - leftSum;

                    if (leftSum == rightSum) {
                        dp[l][r] = Math.max(
                            dp[l][r],
                            Math.max(
                                leftSum + dp[l][k],
                                rightSum + dp[k + 1][r]
                            )
                        );
                    }
                }

                bestLeft[l][r] = Math.max(
                    bestLeft[l][r - 1],
                    total + dp[l][r]
                );

                bestRight[l][r] = Math.max(
                    bestRight[l + 1][r],
                    total + dp[l][r]
                );
            }
        }

        return dp[0][n - 1];
    }
}