class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[k] = num;
                k++;
            }
            
        }
        while (k < nums.length) {
            nums[k] = 0;
            k++;
        }
    }
}
