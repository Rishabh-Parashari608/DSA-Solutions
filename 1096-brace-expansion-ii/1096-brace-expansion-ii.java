import java.util.*;

class Solution {
    int i = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> set = parse(expression);

        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);

        return ans;
    }

    Set<String> parse(String s) {
        Set<String> result = new HashSet<>();

        while (i < s.length() && s.charAt(i) != '}') {

            Set<String> current = new HashSet<>();
            current.add("");

            while (i < s.length() && 
                   s.charAt(i) != ',' && 
                   s.charAt(i) != '}') {

                Set<String> next;

                if (s.charAt(i) == '{') {
                    i++;
                    next = parse(s);
                    i++;
                } else {
                    next = new HashSet<>();
                    next.add(String.valueOf(s.charAt(i)));
                    i++;
                }

                current = multiply(current, next);
            }

            result.addAll(current);

            if (i < s.length() && s.charAt(i) == ',') {
                i++;
            }
        }

        return result;
    }

    Set<String> multiply(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}