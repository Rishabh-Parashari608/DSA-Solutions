
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] next = new int[n];

        int[] stack = new int[n];
        int top = -1;

        for (int i = n - 1; i >= 0; i--) {

            while (top >= 0 && nums[stack[top]] <= nums[i]) {
                top--;
            }

            next[i] = (top == -1) ? n : stack[top];

            stack[++top] = i;
        }

        int LOG = 18;

        int[][] up = new int[LOG][n];
        long[][] sum = new long[LOG][n];

        for (int i = 0; i < n; i++) {

            up[0][i] = next[i];

            sum[0][i] =
                (long) nums[i] * (next[i] - i)
                - (prefix[next[i]] - prefix[i]);
        }

        for (int j = 1; j < LOG; j++) {

            for (int i = 0; i < n; i++) {

                int mid = up[j - 1][i];

                if (mid < n) {
                    up[j][i] = up[j - 1][mid];

                    sum[j][i] =
                        sum[j - 1][i] + sum[j - 1][mid];

                } else {
                    up[j][i] = n;
                    sum[j][i] = sum[j - 1][i];
                }
            }
        }

        long answer = 0;

        int right = -1;

        for (int left = 0; left < n; left++) {

            while (right + 1 < n &&
                   getCost(left, right + 1, nums,
                           prefix, up, sum, LOG) <= k) {

                right++;
            }

            answer += right - left + 1;
        }

        return answer;
    }

    private long getCost(
        int left,
        int right,
        int[] nums,
        long[] prefix,
        int[][] up,
        long[][] sum,
        int LOG
    ) {

        long cost = 0;
        int current = left;

        for (int j = LOG - 1; j >= 0; j--) {

            int nextIndex = up[j][current];

            if (nextIndex <= right) {

                cost += sum[j][current];

                current = nextIndex;
            }
        }

        cost += (long) nums[current] * (right - current + 1)
                - (prefix[right + 1] - prefix[current]);

        return cost;
    }
}
