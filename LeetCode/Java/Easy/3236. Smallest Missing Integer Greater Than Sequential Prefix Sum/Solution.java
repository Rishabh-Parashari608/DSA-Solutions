import java.util.Arrays;
class Solution {
    public int missingInteger(int[] nums) {
        ArrayList<Integer> prefix = new ArrayList<>();
        prefix.add(nums[0]);
        prefix.add(nums[1]);
        int d = nums[1] - nums[0];
        int sum = nums[0] + nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + d) {
                prefix.add(nums[i]);
                sum += nums[i];
            }
        } 
        Arrays.sort(nums);
        for (int num : nums) {
            if (num == sum) {
                sum++;
            }
        }
        return sum;
    }
}