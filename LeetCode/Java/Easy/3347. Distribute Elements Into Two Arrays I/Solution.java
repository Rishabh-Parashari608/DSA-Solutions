class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        int[] nums1 = new int[n];
        int[] nums2 = new int[n];

        nums1[0] = nums[0];
        nums2[0] = nums[1];

        int size1 = 1;
        int size2 = 1;

        for (int i = 2; i < n; i++) {
            if (nums1[size1 - 1] > nums2[size2 - 1]) {
                nums1[size1] = nums[i];
                size1++;
            } else {
                nums2[size2] = nums[i];
                size2++;
            }
        }

        int[] res = new int[size1 + size2];

        int index = 0;

        for (int i = 0; i < size1; i++) {
            res[index] = nums1[i];
            index++;
        }

        for (int i = 0; i < size2; i++) {
            res[index] = nums2[i];
            index++;
        }

        return res;
    }
}