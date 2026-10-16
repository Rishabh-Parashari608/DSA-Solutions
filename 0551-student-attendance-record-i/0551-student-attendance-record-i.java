class Solution {
    public boolean checkRecord(String s) {
        char[] ch = s.toCharArray();
        int AbsentCount = 0;
        int ConsecutiveLate = 0;

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'A') {
                AbsentCount++;
                if (AbsentCount > 1) {
                    return false;
                }
            }
            if (ch[i] == 'L') {
                ConsecutiveLate++;
                if (i > 0) {
                    if (ch[i-1] != 'L') {
                        ConsecutiveLate = 1;
                    }
                }
            }
            if (ConsecutiveLate == 3) {
                return false;
            }
        }
        return true;
    }
}