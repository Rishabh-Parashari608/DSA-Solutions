class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (char[] row : matrix) {
            for (int j = 0; j < cols; j++) {
                heights[j] = row[j] == '1' ? heights[j] + 1 : 0;
            }

            maxArea = Math.max(maxArea, largestRectangle(heights));
        }

        return maxArea;
    }

    private int largestRectangle(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n + 1];
        int top = -1;
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int curr = i == n ? 0 : heights[i];

            while (top >= 0 && heights[stack[top]] > curr) {
                int h = heights[stack[top--]];
                int width = top == -1 ? i : i - stack[top] - 1;
                maxArea = Math.max(maxArea, h * width);
            }

            stack[++top] = i;
        }

        return maxArea;
    }
}