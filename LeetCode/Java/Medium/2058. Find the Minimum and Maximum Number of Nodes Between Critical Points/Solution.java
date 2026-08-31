class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1, -1};

        if (head == null || head.next == null || head.next.next == null) {
            return ans;
        }

        ListNode prevNode = head;
        ListNode curr = head.next;

        int pos = 1;
        int first = -1;
        int prev = -1;
        int min = Integer.MAX_VALUE;
        int last = -1;

        while (curr.next != null) {
            int prevVal = prevNode.val;
            int currVal = curr.val;
            int nextVal = curr.next.val;

            if ((currVal > prevVal && currVal > nextVal) ||
                (currVal < prevVal && currVal < nextVal)) {

                if (first == -1) {
                    first = pos;
                }

                if (prev != -1) {
                    min = Math.min(min, pos - prev);
                }

                prev = pos;
                last = pos;
            }

            prevNode = curr;
            curr = curr.next;
            pos++;
        }

        if (first == -1 || first == last) {
            return ans;
        }

        ans[0] = min;
        ans[1] = last - first;

        return ans;
    }
}