import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int count = 0;

        int[] digitSum = new int[n];

        for (int i = 0; i < n; i++) {
            int rem = 0;
            int x = nums[i];

            while (x > 0) {
                rem += x % 10;
                x /= 10;
            }

            digitSum[i] = rem;
        }

        int[][] original = new int[n][3];

        for (int i = 0; i < n; i++) {
            original[i][0] = digitSum[i];
            original[i][1] = nums[i];
            original[i][2] = i;
        }

        Arrays.sort(original, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] || original[i][2] == i) {
                continue;
            }

            int j = i;
            int cycle = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = original[j][2];
                cycle++;
            }

            count += cycle - 1;
        }

        return count;
    }
}