class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> Even = new ArrayList<>();
        ArrayList<Integer> Odd = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0)
                Even.add(nums[i]);
            else
                Odd.add(nums[i]);
        }

        int evenIndex = 0;
        int oddIndex = 0;

        for (int j = 0; j < n; j++) {
            if (j % 2 == 0) {
                nums[j] = Even.get(evenIndex);
                evenIndex++;
            }
                
            else {
                nums[j] = Odd.get(oddIndex);
                oddIndex++;
            }
                
        }

        return nums;
    }
}