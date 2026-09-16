class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> ban = new HashSet<>();

        for (String s : banned)
            ban.add(s);

        paragraph = paragraph.toLowerCase().replaceAll("[!?',;.]", " ");

        HashMap<String, Integer> map = new HashMap<>();
        String ans = "";
        int max = 0;

        for (String word : paragraph.split(" ")) {
            if (word.isEmpty() || ban.contains(word))
                continue;

            int count = map.getOrDefault(word, 0) + 1;
            map.put(word, count);

            if (count > max) {
                max = count;
                ans = word;
            }
        }

        return ans;
    }
}