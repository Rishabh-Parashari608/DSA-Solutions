class Solution {
    public int countPartitions(int[] nums) {
        int count = 0;

        ArrayList<Integer> p1 = new ArrayList<>();
        ArrayList<Integer> p2 = new ArrayList<>();

        for (int num : nums) {
            p2.add(num);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            p1.add(nums[i]);
            p2.remove(0);

            int s1 = 0;
            int s2 = 0;

            for (int num1 : p1) {
                s1 += num1;
            }
            for (int num2 : p2) {
                s2 += num2;
            }

            if ((s1 - s2) % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}