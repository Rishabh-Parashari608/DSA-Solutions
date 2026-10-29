
import java.util.*;

class Solution {
    List<Integer>[] adj;
    int[] tin, tout, parent, depth, prefix, size;
    int[][] up;
    int LOG;
    int timer;
    char[] chars;
    Fenwick bit;

    public List<Boolean> palindromePath(int n, int[][] edges,
                                         String s, String[] queries) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        chars = s.toCharArray();
        tin = new int[n];
        tout = new int[n];
        parent = new int[n];
        depth = new int[n];
        prefix = new int[n];
        size = new int[n];

        Arrays.fill(parent, -1);

        // Iterative DFS: preorder traversal
        int[] order = new int[n];
        int[] stack = new int[n];
        int top = 0;
        int count = 0;

        stack[top++] = 0;

        while (top > 0) {
            int u = stack[--top];
            tin[u] = count;
            order[count++] = u;
            size[u] = 1;

            prefix[u] = (parent[u] == -1 ? 0 : prefix[parent[u]])
                      ^ (1 << (chars[u] - 'a'));

            for (int v : adj[u]) {
                if (v == parent[u]) continue;

                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }

        // Calculate subtree sizes and Euler exit times.
        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            size[parent[u]] += size[u];
        }

        for (int u = 0; u < n; u++) {
            tout[u] = tin[u] + size[u] - 1;
        }

        // Binary lifting table for LCA.
        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        up = new int[LOG][n];

        for (int u = 0; u < n; u++) {
            up[0][u] = parent[u] == -1 ? 0 : parent[u];
        }

        for (int k = 1; k < LOG; k++) {
            for (int u = 0; u < n; u++) {
                up[k][u] = up[k - 1][up[k - 1][u]];
            }
        }

        bit = new Fenwick(n);

        List<Boolean> answer = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);

                int delta = (1 << (chars[u] - 'a'))
                          ^ (1 << (c - 'a'));

                // Changing u affects every root path in its subtree.
                bit.rangeXor(tin[u], tout[u], delta);
                chars[u] = c;

            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int lca = findLCA(u, v);

                int maskU = prefix[u] ^ bit.pointQuery(tin[u]);
                int maskV = prefix[v] ^ bit.pointQuery(tin[v]);

                int mask = maskU ^ maskV
                         ^ (1 << (chars[lca] - 'a'));

                answer.add((mask & (mask - 1)) == 0);
            }
        }

        return answer;
    }

    int findLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) return u;

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return parent[u];
    }

    class Fenwick {
        int[] tree;
        int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 2];
        }

        void update(int i, int mask) {
            i++;

            while (i <= n) {
                tree[i] ^= mask;
                i += i & -i;
            }
        }

        int query(int i) {
            int mask = 0;
            i++;

            while (i > 0) {
                mask ^= tree[i];
                i -= i & -i;
            }

            return mask;
        }

        void rangeXor(int left, int right, int mask) {
            update(left, mask);
            if (right + 1 < n) {
                update(right + 1, mask);
            }
        }

        int pointQuery(int index) {
            return query(index);
        }
    }
}
