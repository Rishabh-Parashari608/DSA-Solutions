class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] aA = convert(arriveAlice);
        int[] lA = convert(leaveAlice);
        int[] aB = convert(arriveBob);
        int[] lB = convert(leaveBob);

        int[] monthdays = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

        int aAD = monthdays[aA[0]] + aA[1];
        int lAD = monthdays[lA[0]] + lA[1];
        int aBD = monthdays[aB[0]] + aB[1];
        int lBD = monthdays[lB[0]] + lB[1];

        int start = Math.max(aAD, aBD);
        int end = Math.min(lAD, lBD);

        return Math.max(0, end - start + 1);
    }
    private int[] convert(String date) {
        String[] parts = date.split("-");
        return new int[] {
            Integer.parseInt(parts[0]), 
            Integer.parseInt(parts[1])
        };
    }
}