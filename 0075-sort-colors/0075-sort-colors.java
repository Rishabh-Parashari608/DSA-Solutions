class Solution {
    public void sortColors(int[] nums) {
        int[] c = new int[3];

        for (int x : nums) c[x]++;

        int i = 0;
        for (int x = 0; x < 3; x++)
            while (c[x]-- > 0) nums[i++] = x;
    }
}