class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (count == 1){
                    nums[j] = nums[i];
                    count++;
                    j++;
                } 
                
            } else {
                nums[j] = nums[i];
                count = 1;
                j++;
            }
            
        }
        return j;
    }
}