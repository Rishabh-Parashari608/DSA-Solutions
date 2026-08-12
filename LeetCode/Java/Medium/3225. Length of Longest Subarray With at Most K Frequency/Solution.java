class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int n = set.size();
        if (n * k > nums.length) {
            return nums.length;
        }
        return n * k;
    }
}