
import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }

        int[][] dist = new int[n][k + 1];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int cost = curr[0];
            int node = curr[1];
            int count = curr[2];

            if (cost != dist[node][count]) {
                continue;
            }

            if (node == n - 1) {
                return cost;
            }

            for (int[] e : graph[node]) {
                int next = e[0];
                int weight = e[1];

                int newCount = (labels.charAt(next) ==
                                labels.charAt(node))
                                ? count + 1 : 1;

                if (newCount > k) {
                    continue;
                }

                int newCost = cost + weight;

                if (newCost < dist[next][newCount]) {
                    dist[next][newCount] = newCost;
                    pq.offer(new int[]{
                        newCost, next, newCount
                    });
                }
            }
        }

        return -1;
    }
}
