class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] ans = new int[m];
        int[] last = new int[m];

        java.util.Arrays.fill(last, -1);

        int i = n - 1, j = m - 1;

        while (i >= 0 && j >= 0) {
            if (word1.charAt(i) == word2.charAt(j))
                last[j--] = i;
            i--;
        }

        boolean used = false;
        j = 0;

        for (i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j++] = i;
            } else if (!used && (j == m - 1 || i < last[j + 1])) {
                ans[j++] = i;
                used = true;
            }
        }

        return j == m ? ans : new int[0];
    }
}