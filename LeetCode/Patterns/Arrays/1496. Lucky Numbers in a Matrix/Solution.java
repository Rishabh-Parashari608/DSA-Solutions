import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int minCol = 0;

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < matrix[i][minCol]) {
                    minCol = j;
                }
            }

            int value = matrix[i][minCol];

            boolean isMax = true;
            for (int j = 0; j < m; j++) {
                if (matrix[j][minCol] > value) {
                    isMax = false;
                    break;
                }
            }

            if (isMax) {
                res.add(value);
            }
        }

        return res;
    }
}