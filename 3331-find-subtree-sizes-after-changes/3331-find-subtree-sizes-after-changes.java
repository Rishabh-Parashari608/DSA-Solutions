
import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        int[] last = new int[26];

        Arrays.fill(last, -1);

        dfs(0, tree, s, last, newParent);

        List<Integer>[] newTree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            newTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }

        int[] ans = new int[n];

        calculateSize(0, newTree, ans);

        return ans;
    }

    void dfs(int node, List<Integer>[] tree, String s,
             int[] last, int[] newParent) {

        int ch = s.charAt(node) - 'a';

        int previous = last[ch];

        if (node != 0 && previous != -1) {
            newParent[node] = previous;
        }

        last[ch] = node;

        for (int child : tree[node]) {
            dfs(child, tree, s, last, newParent);
        }

        last[ch] = previous;
    }

    int calculateSize(int node, List<Integer>[] tree, int[] ans) {
        int size = 1;

        for (int child : tree[node]) {
            size += calculateSize(child, tree, ans);
        }

        ans[node] = size;

        return size;
    }
}
