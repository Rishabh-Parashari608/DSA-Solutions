class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 1;
        int element = matrix[0][0];
        while (i <= m - 1) {
            if (matrix[i][i] == element) {
                i++;
            } else {
                break;
            }
        }
        if (i == m) {
            return true;
        } else {
            return false;
        }
    }
}