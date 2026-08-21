import java.util.*;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        List<Integer> value = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            for (int n = 1; n < 25; n++) {
                value.add(coins[i] * n);
            }
        }

        int n = value.size();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            res.add(value.get(i));
        }

        Collections.sort(res);

        return res.get(k - 1);
    }
}