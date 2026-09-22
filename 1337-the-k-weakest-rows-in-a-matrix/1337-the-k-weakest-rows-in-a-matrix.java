class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int[][] rows = new int[n][2];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int x : mat[i]) {
                if (x == 1) {
                    count++;
                }
                
            }
            rows[i][0] = count;
            rows[i][1] = i;
        }
        Arrays.sort(rows, (a, b) -> {
            if(a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            }
            return Integer.compare(a[1], b[1]);
        });
        int[] ans = new int[k];

        for(int i = 0; i < k; i++) {
            ans[i] = rows[i][1];
        }
        return ans;
    }
}