class Solution {

    class Node {
        char leftChar, rightChar;
        int prefix, suffix, max, length;

        Node(char leftChar, char rightChar, int prefix,
             int suffix, int max, int length) {
            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.prefix = prefix;
            this.suffix = suffix;
            this.max = max;
            this.length = length;
        }
    }

    private char[] arr;
    private Node[] tree;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {

        int n = s.length();
        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] answer = new int[k];

        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i],
                   queryCharacters.charAt(i));

            answer[i] = tree[1].max;
        }

        return answer;
    }

    private void build(int node, int left, int right) {

        if (left == right) {
            tree[node] = new Node(
                arr[left],
                arr[left],
                1,
                1,
                1,
                1
            );
            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(int node, int left, int right,
                        int index, char ch) {

        if (left == right) {
            arr[index] = ch;

            tree[node] = new Node(
                ch,
                ch,
                1,
                1,
                1,
                1
            );
            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, ch);
        } else {
            update(node * 2 + 1, mid + 1, right, index, ch);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node merge(Node left, Node right) {

        Node result = new Node(
            left.leftChar,
            right.rightChar,
            left.prefix,
            right.suffix,
            Math.max(left.max, right.max),
            left.length + right.length
        );

        if (left.prefix == left.length &&
            left.rightChar == right.leftChar) {

            result.prefix = left.length + right.prefix;
        }

        if (right.suffix == right.length &&
            left.rightChar == right.leftChar) {

            result.suffix = right.length + left.suffix;
        }

        if (left.rightChar == right.leftChar) {

            result.max = Math.max(
                result.max,
                left.suffix + right.prefix
            );
        }

        return result;
    }
}