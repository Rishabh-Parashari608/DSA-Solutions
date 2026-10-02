class Solution {
    public int countOfPairs(int[] nums) {
        int MOD = 1_000_000_007;
        int n = nums.length;

        long[][] dp = new long[n][51];
        for (int x = 0; x <= nums[0]; x++) {
            dp[0][x] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int x = 0; x <= nums[i]; x++) {
                int y = nums[i] - x;

                for (int prev = 0; prev <= nums[i - 1]; prev++) {
                    int prevY = nums[i - 1] - prev;

                    if (prev <= x && prevY >= y) {
                        dp[i][x] = (dp[i][x] + dp[i - 1][prev]) % MOD;
                    }
                }
            }
        }
        long ans = 0;

        for (int x = 0; x <= nums[n - 1]; x++) {
            ans = (ans + dp[n - 1][x]) % MOD;
        }

        return (int) ans;
    }
}