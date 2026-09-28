class Solution {
    public int maxDepth(String s) {
        int bracket = 0;
        int pair = 0;
        int nested = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bracket++;
            }  
            if (s.charAt(i) == ')') {
                pair = bracket;
                bracket--;
            } 
            nested = Math.max(nested, pair);
        }
        return nested;
    }
}