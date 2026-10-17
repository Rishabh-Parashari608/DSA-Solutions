class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        char[] ch1 = jewels.toCharArray();
        char[] ch2 = stones.toCharArray();

        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                if (ch1[i] == ch2[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}