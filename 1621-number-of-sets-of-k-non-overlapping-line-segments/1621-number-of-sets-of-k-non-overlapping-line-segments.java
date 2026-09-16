class Solution {
    public int numberOfSets(int n, int k) {
        long MOD = 1000000007;
        long ans = 1;

        for (int i = 1; i <= 2 * k; i++) {
            ans = ans * (n + k - i) % MOD;
            ans = ans * modPow(i, MOD - 2) % MOD;
        }

        return (int) ans;
    }

    private long modPow(long a, long b) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % 1000000007;

            a = a * a % 1000000007;
            b >>= 1;
        }

        return res;
    }
}