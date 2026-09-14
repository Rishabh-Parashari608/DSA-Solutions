class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] ans = new int[rows*cols][2];
        int k = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                ans[k][0] = r;
                ans[k][1] = c;
                k++;
            }
        }
        Arrays.sort(ans, (a, b) -> Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter) - Math.abs(b[0] - rCenter) - Math.abs(b[1] - cCenter));
        return ans;
    }
}