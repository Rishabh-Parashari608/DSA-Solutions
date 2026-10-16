class Solution {
    public boolean validPalindrome(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int left = 0;
        int right = n - 1;
        int chance = 1;
        while (left < right) {
            if (ch[left] == ch[right]) {
                left++;
                right--;
            } else if (chance == 1) {
                chance--;
                int l = left + 1;
                int r = right;
                while (l < r && ch[l] == ch[r]) {
                    l++;
                    r--;
                }
                if (l >= r) {
                    return true;
                }

                l = left;
                r = right - 1;
                while (l < r && ch[l] == ch[r]) {
                    l++;
                    r--;
                }
                return l >= r;
                
            } else {
                return false;
            }
        }
        return true;
    }
}