class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    void backtrack(int[] nums, List<Integer> current, boolean[] used) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            current.add(nums[i]);

            backtrack(nums, current, used);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}