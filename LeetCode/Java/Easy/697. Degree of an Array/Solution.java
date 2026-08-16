class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] count = new int[50000];
        int[] first = new int[50000];

        Arrays.fill(first, -1);

        int degree = 0;
        int minLength= nums.length;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (first[num] == -1) {
                first[num] = i;
            }
            count[num]++;

            if (count[num] > degree) {
                degree = count[num];
                minLength = i - first[num] + 1;
            } else if (count[num] == degree) {
                minLength = Math.min(minLength, i - first[num] + 1);
            }
        }
        return minLength;
    }
}