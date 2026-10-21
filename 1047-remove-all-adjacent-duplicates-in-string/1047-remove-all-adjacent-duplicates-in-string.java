
class Solution {
    public String removeDuplicates(String s) {
        // StringBuilder sb = new StringBuilder();

        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);

        //     if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ch) {
        //         sb.deleteCharAt(sb.length() - 1);
        //     } else {
        //         sb.append(ch);
        //     }
        // }

        // return sb.toString();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!st.isEmpty() && st.peek() == ch) {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        String ans = "";
        while(!st.isEmpty()) {
            ans = st.pop() + ans;
        }
        return ans;
    }
}
