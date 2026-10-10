
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int[] diff = new int[n];
        int max = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            sum += diff[i];
        }

        if (sum <= k) return 0;

        int low = 0, high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                needed += Math.max(0, d - mid);
            }

            if (needed <= k) high = mid;
            else low = mid + 1;
        }

        long ans = 0;
        long used = 0;

        for (int d : diff) {
            int reduced = Math.min(d, low);
            used += d - reduced;
            ans += (long) reduced * reduced;
        }

        long remaining = k - used;

        for (int d : diff) {
            if (remaining == 0) break;
            if (d >= low && d > 0) {
                ans -= (long) low * low;
                ans += (long) (low - 1) * (low - 1);
                remaining--;
            }
        }

        return ans;
    }
}
