import java.util.*;

class Solution {

    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;

        long low = 1;
        long high = (long) coins[0] * k;

        while (low < high) {
            long mid = low + (high - low) / 2;

            long count = countNumbers(mid, coins);

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long countNumbers(long x, int[] coins) {
        int n = coins.length;
        long count = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    long gcd = gcd(lcm, coins[i]);
                    lcm = lcm / gcd * coins[i];

                    if (lcm > x) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            long multiples = x / lcm;

            if (bits % 2 == 1) {
                count += multiples;
            } else {
                count -= multiples;
            }
        }

        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}