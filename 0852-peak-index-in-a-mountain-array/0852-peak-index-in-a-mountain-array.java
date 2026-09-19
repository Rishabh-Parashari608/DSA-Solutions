class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                ans = i;
            }
        }
        return ans;
    }
}