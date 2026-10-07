class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();

        q.add(s);
        seen.add(s);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean found = false;

            while (size-- > 0) {
                String str = q.poll();

                if (valid(str)) {
                    ans.add(str);
                    found = true;
                }

                if (found) continue;

                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == ')'
                            || str.charAt(i) == '(') {

                        String next = str.substring(0, i) + str.substring(i + 1);

                        if (seen.add(next))
                            q.add(next);
                    }
                }
            }

            if (found) break;
        }

        return ans;
    }

    private boolean valid(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')' && --count < 0) return false;
        }

        return count == 0;
    }
}