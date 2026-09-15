class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                index = i;
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                for (int j = 0; j < nums.length; j++) {
                    arr.add(nums[j]);
                }
                arr.add(target);
                Collections.sort(arr);
                index = arr.indexOf(target);
            }
        }
        return index;
    }
}