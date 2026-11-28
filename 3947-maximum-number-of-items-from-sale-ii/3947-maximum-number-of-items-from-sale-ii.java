
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;
        int maxFactor = 0;
        long minPrice = Long.MAX_VALUE;
        int[] freq = new int[n + 1];

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            freq[factor]++;

            maxFactor = Math.max(maxFactor, factor);
            minPrice = Math.min(minPrice, price);
        }

        int[] divisible = new int[maxFactor + 1];

        for (int f = 1; f <= maxFactor; f++) {

            for (int j = f; j <= maxFactor; j += f) {
                divisible[f] += freq[j];
            }

            divisible[f]--;
        }

        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        long remaining = budget;
        long ans = 0;

        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            if (price >= 2 * minPrice) {
                break;
            }

            long gain = divisible[factor];
            if (gain <= 0) {
                continue;
            }

            long take = Math.min(gain, remaining / price);
            ans += take * 2;
            remaining -= take * price;
        }
        ans += remaining / minPrice;

        return (int) ans;
    }
}
