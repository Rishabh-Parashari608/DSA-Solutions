class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];

        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            int j = 0;
            int len = Math.min(first.length(), second.length());

            while (j < len) {
                char ch1 = first.charAt(j);
                char ch2 = second.charAt(j);

                if (ch1 != ch2) {
                    if (rank[ch1 - 'a'] > rank[ch2 - 'a']) {
                        return false;
                    }
                    break;
                }
                j++;
            }
            if (j == len && first.length() > second.length()) {
                return false;
            }
        }
        return true;
    }
}