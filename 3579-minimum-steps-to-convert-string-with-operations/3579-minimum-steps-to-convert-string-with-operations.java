class Solution {
    public int minOperations(String word1, String word2) {
        int n = word1.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int cost = getCost(word1, word2, i, j, false);
                cost = Math.min(cost, 1 + getCost(word1, word2, i, j, true));

                dp[j + 1] = Math.min(dp[j + 1], dp[i] + cost);
            }
        }

        return dp[n];
    }

    private int getCost(String a, String b, int l, int r, boolean reverse) {
        int[][] cnt = new int[26][26];
        int mismatches = 0;

        for (int i = l; i <= r; i++) {
            char x = reverse ? a.charAt(r - (i - l)) : a.charAt(i);
            char y = b.charAt(i);

            if (x != y) {
                cnt[x - 'a'][y - 'a']++;
                mismatches++;
            }
        }

        int swaps = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                swaps += Math.min(cnt[i][j], cnt[j][i]);
            }
        }

        return mismatches - swaps;
    }
}