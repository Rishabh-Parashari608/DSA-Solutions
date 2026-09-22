class Solution {
    int n, k;
    int[][] tree;
    int[] product;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;

        tree = new int[4 * n][k];
        product = new int[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            update(1, 0, n - 1, index, value % k);

            int[] result = query(1, 0, n - 1, start, n - 1);

            ans[q] = result[x];
        }

        return ans;
    }

    void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            int v = nums[l] % k;
            product[node] = v;
            tree[node][v] = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        merge(node, node * 2, node * 2 + 1);
    }

    void update(int node, int l, int r, int index, int value) {
        if (l == r) {
            product[node] = value;

            for (int i = 0; i < k; i++)
                tree[node][i] = 0;

            tree[node][value] = 1;
            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid)
            update(node * 2, l, mid, index, value);
        else
            update(node * 2 + 1, mid + 1, r, index, value);

        merge(node, node * 2, node * 2 + 1);
    }

    void merge(int node, int left, int right) {
        for (int i = 0; i < k; i++)
            tree[node][i] = tree[left][i];

        for (int b = 0; b < k; b++) {
            int rem = (product[left] * b) % k;
            tree[node][rem] += tree[right][b];
        }

        product[node] = (product[left] * product[right]) % k;
    }

    int[] query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            int[] result = new int[k + 1];

            for (int i = 0; i < k; i++)
                result[i] = tree[node][i];

            result[k] = product[node];

            return result;
        }

        int mid = (l + r) / 2;

        if (qr <= mid)
            return query(node * 2, l, mid, ql, qr);

        if (ql > mid)
            return query(node * 2 + 1, mid + 1, r, ql, qr);

        int[] left = query(node * 2, l, mid, ql, qr);
        int[] right = query(node * 2 + 1, mid + 1, r, ql, qr);

        int[] result = new int[k + 1];

        for (int i = 0; i < k; i++)
            result[i] = left[i];

        int leftProduct = left[k];

        for (int b = 0; b < k; b++) {
            int rem = (leftProduct * b) % k;
            result[rem] += right[b];
        }

        result[k] = (leftProduct * right[k]) % k;

        return result;
    }
}