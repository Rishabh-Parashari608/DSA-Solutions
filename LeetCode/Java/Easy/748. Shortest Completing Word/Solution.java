class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] required = new int[26];

        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                required[c - 'a']++;
            }
        }

        String answer = "";

        for (String word : words) {
            if (!answer.isEmpty() && word.length() >= answer.length()) {
                continue;
            }

            int[] count = new int[26];

            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            boolean valid = true;

            for (int i = 0; i < 26; i++) {
                if (count[i] < required[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                answer = word;
            }
        }

        return answer;
    }
}