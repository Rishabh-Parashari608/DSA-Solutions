class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        int[] dp = new int[n + 1];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j) &&
                    (len <= 2 || pal[i + 1][j - 1])) {
                    pal[i][j] = true;
                }
            }
        }

        for (int j = 1; j <= n; j++) {
            dp[j] = dp[j - 1];

            for (int i = 0; i < j; i++) {
                if (j - i >= k && pal[i][j - 1]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        return dp[n];
    }
}