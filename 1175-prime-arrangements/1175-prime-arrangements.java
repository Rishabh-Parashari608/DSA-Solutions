class Solution {
    public int numPrimeArrangements(int n) {
        long MOD = 1000000007;
        int prime = 0;

        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) prime++;
        }

        long ans = 1;

        for (int i = 2; i <= prime; i++) {
            ans = ans * i % MOD;
        }

        for (int i = 2; i <= n - prime; i++) {
            ans = ans * i % MOD;
        }

        return (int) ans;
    }
}