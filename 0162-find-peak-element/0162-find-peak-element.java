class Solution {
    public int findPeakElement(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                ans = i;
            }
        }
        return ans;
    }
}