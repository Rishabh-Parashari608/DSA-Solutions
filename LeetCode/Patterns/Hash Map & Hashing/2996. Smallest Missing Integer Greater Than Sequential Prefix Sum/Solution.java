class Solution {
    public int missingInteger(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length-1] + 1);
    }
}