
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int[] rev = new int[n];

        for (int i = 0; i < n; i++) {
            rev[i] = nums[n - 1 - i];
        }

        int ans = Integer.MAX_VALUE;

        int start = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                start = i;
                break;
            }
        }

        boolean ok = true;

        for (int i = 0; i < n; i++) {
            if (nums[(start + i) % n] != i) {
                ok = false;
                break;
            }
        }

        if (ok) {
            ans = Math.min(ans, Math.min(start, n - start + 2));
        }

        start = -1;

        for (int i = 0; i < n; i++) {
            if (rev[i] == 0) {
                start = i;
                break;
            }
        }

        ok = true;

        for (int i = 0; i < n; i++) {
            if (rev[(start + i) % n] != i) {
                ok = false;
                break;
            }
        }

        if (ok) {
            ans = Math.min(ans, 1 + Math.min(start, n - start));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
