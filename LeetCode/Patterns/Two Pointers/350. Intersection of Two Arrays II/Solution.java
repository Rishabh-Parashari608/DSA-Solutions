class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;

        for (int n : nums1) count[n]++;

        for (int n : nums2)
            if (count[n]-- > 0)
                result[k++] = n;

        return Arrays.copyOf(result, k);
    }
}