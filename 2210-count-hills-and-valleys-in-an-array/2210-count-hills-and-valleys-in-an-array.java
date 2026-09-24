class Solution {
    public int countHillValley(int[] nums) {
        int ans = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i - 1;
            int right = i + 1;

            while (right < nums.length && nums[right] == nums[i]) {
                right++;
            }

            if (right == nums.length) {
                continue;
            }

            if ((nums[i] > nums[left] && nums[i] > nums[right]) || (nums[right] > nums[i] && nums[left] > nums[i])) {
                ans++;
            }
        }
        return ans;
    }
}