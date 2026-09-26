class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    int[] disc;
    int[] low;
    int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        disc = new int[n];
        low = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, -1);

        return ans;
    }
    private void dfs(int u, int parent) {
        disc[u] = low[u] = time++;

        for (int v : graph.get(u)) {
            if (v == parent) {
                continue;
            }

            if (disc[v] == 0) {
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    ans.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}