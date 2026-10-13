
import java.util.*;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long sum = 0;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = nums[i];

        Arrays.sort(arr, (a, b) -> Long.compare((long)b * b, (long)a * a));

        for (int i = 0; i < n; i++) {
            long x = (long) arr[i] * arr[i];
            sum += (i < (n + 1) / 2) ? x : -x;
        }

        return sum;
    }
}
