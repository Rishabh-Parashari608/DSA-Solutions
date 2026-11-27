class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] count = new int[1501];

        for (int[] item : items) {
            count[item[0]]++;
        }

        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            int free = 0;

            for (int j = factor; j <= 1500; j += factor) {
                free += count[j];
            }
            value[i] = free;
        }
        int answer = 0;

        for (int minPrice = 1; minPrice <= 1500; minPrice++) {
            int[] dp = new int[budget + 1];

            boolean found = false;

            for (int i = 0; i < n; i++) {
                int price = items[i][1];

                if (price < minPrice) {
                    continue;
                }

                if (price == minPrice) {
                    found = true;
                }

                for (int j = budget; j >= price; j--) {
                    dp[j] = Math.max(dp[j], dp[j - price] + value[i]);
                }
            }

            if (!found) {
                continue;
            }

            for (int cost = 1; cost <= budget; cost++) {
                if (dp[cost] > 0) {
                    int total = dp[cost] + (budget - cost) / minPrice;

                    answer = Math.max(answer, total);
                }
            }
        }
        return answer;
    }
}