
import java.util.*;

class Solution {

    class Fenwick {
        int n;
        long[] tree;

        Fenwick(int n) {
            this.n = n;
            tree = new long[n + 1];
        }

        void add(int i, long val) {
            while (i <= n) {
                tree[i] += val;
                i += i & -i;
            }
        }

        long sum(int i) {
            long ans = 0;
            while (i > 0) {
                ans += tree[i];
                i -= i & -i;
            }
            return ans;
        }

        int kth(long k) {
            int idx = 0;
            int bit = Integer.highestOneBit(n);

            for (; bit > 0; bit >>= 1) {
                int next = idx + bit;

                if (next <= n && tree[next] < k) {
                    idx = next;
                    k -= tree[next];
                }
            }

            return idx + 1;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int m = 0;

        for (int v : sorted) {
            if (m == 0 || sorted[m - 1] != v) {
                sorted[m++] = v;
            }
        }

        Fenwick count = new Fenwick(m);
        Fenwick sum = new Fenwick(m);

        long totalSum = 0;

        long[] cost = new long[n - x + 1];

        for (int i = 0; i < n; i++) {

            int pos = Arrays.binarySearch(sorted, 0, m, nums[i]) + 1;

            count.add(pos, 1);
            sum.add(pos, nums[i]);
            totalSum += nums[i];

            if (i >= x) {
                int oldPos = Arrays.binarySearch(
                    sorted, 0, m, nums[i - x]
                ) + 1;

                count.add(oldPos, -1);
                sum.add(oldPos, -((long) nums[i - x]));
                totalSum -= nums[i - x];
            }

            if (i >= x - 1) {

                long medianRank = (x + 1L) / 2;

                int medianPos = count.kth(medianRank);
                long median = sorted[medianPos - 1];

                long leftCount = count.sum(medianPos);
                long leftSum = sum.sum(medianPos);

                long rightCount = x - leftCount;
                long rightSum = totalSum - leftSum;

                long leftCost =
                    median * leftCount - leftSum;

                long rightCost =
                    rightSum - median * rightCount;

                cost[i - x + 1] = leftCost + rightCost;
            }
        }

        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        Arrays.fill(prev, 0);

        for (int j = 1; j <= k; j++) {

            long[] curr = new long[n + 1];
            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                curr[i] = curr[i - 1];

                if (i >= x && prev[i - x] != INF) {

                    long candidate =
                        prev[i - x] + cost[i - x];

                    curr[i] = Math.min(
                        curr[i],
                        candidate
                    );
                }
            }

            prev = curr;
        }

        return prev[n];
    }
}
