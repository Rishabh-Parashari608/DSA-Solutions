class Solution {
    public String makeGood(String s) {
        // StringBuilder sb = new StringBuilder();

        // for (char ch : s.toCharArray()) {
        //     int n = sb.length();

        //     if (n > 0 && Math.abs(sb.charAt(n - 1) - ch) == 32) {
        //         sb.deleteCharAt(n - 1);
        //     } else {
        //         sb.append(ch);
        //     }
        // }

        // return sb.toString();

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && Math.abs(st.peek() - ch) == 32) {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : st) {
            ans.append(ch);
        }

        return ans.toString();
    }
}