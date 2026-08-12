class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] seen = new boolean[nums.length + 1];
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            seen[num] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!seen[i]) {
                result.add(i);
            }
        }
        return result;
    }
}