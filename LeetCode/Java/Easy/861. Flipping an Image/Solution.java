class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int left = 0;
            int right = image[0].length - 1;

            while(left < right) {
                int temp = image[i][left];
                image[i][left] = image[i][right];
                image[i][right] = temp;

                left++;
                right--;
            }
        }
        int m = image.length;
        int n = image[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (image[i][j] == 0) {
                    image[i][j] = 1;
                } else {
                    image[i][j] = 0;
                }
            }
        }

        return image;
    }
}