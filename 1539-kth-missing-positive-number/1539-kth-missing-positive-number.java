class Solution {
    public int findKthPositive(int[] arr, int k) {
        int m = 1;
        int i = 0;

        while (true) {
            if (i < arr.length && arr[i] == m) {
                i++;
            } else {
                k--;

                if (k == 0) {
                    return m;
                }
            }

            m++;
        }
    }
}