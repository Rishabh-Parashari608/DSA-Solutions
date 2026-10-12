class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long mod = 1_000_000_007L;
        long[] bits = new long[31];

        for (int x : nums)
            for (int b = 0; b < 31; b++)
                if ((x & (1 << b)) != 0) bits[b]++;

        long ans = 0;

        for (int i = 0; i < k; i++) {
            long x = 0;
            for (int b = 30; b >= 0; b--)
                if (bits[b] > 0) {
                    x |= 1L << b;
                    bits[b]--;
                }
            ans = (ans + x * x) % mod;
        }

        return (int) ans;
    }
}