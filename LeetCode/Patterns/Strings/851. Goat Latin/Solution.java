class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++) {
            char c = words[i].charAt(0);
            if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                words[i] = words[i].substring(1) + c;
            }
            
        }
        for(int j = 0; j < words.length; j++) {
            words[j] = words[j] + "m";
        }
        
        String ext = "aa";
        int k = 0;
        while(k < words.length) {
            words[k] = words[k] + ext;
            ext += "a";
            k++;
        }
        String result = String.join(" ", words);
        return result;
    }
}