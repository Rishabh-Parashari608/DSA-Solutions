class Solution {
    public int countBinarySubstrings(String s) {
        char[] arr = s.toCharArray();
        int countZero = 0;
        int countOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0') {
                countZero += 1;
            } else {
                countOne += 1;
            }
        } 
        int count = Math.min(countZero, countOne);
        return count + 2;
    }
}