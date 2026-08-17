import java.util.Arrays;

class Solution {
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        
        if (n == 1) return 0;

        int[] copy = nums.clone();
        Arrays.sort(copy);

        int max = copy[n - 1];

        if (max >= 2 * copy[n - 2]) {
            for (int i = 0; i < n; i++) {
                if (nums[i] == max) {
                    return i;
                }
            }
        }

        return -1;
    }
}