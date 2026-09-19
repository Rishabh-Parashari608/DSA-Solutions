class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int[][] rows = new int[n][2];

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }

            rows[i][0] = count;
            rows[i][1] = i;
        }

        Arrays.sort(rows, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = rows[i][1];
        }

        return ans;
    }
}