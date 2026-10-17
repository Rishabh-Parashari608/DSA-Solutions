
class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        int[] freq = new int[26];

        Arrays.fill(freq, 101);

        for (String word : words) {
            int[] count = new int[26];

            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                freq[i] = Math.min(freq[i], count[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                ans.add("" + (char)(i + 'a'));
                freq[i]--;
            }
        }

        return ans;
    }
}
