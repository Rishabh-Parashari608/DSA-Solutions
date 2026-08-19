import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.computeIfAbsent(row, k -> new HashSet<>()).add(col);
        }

        int answer = 2 * n;

        for (Set<Integer> seats : map.values()) {
            boolean left = true;  
            boolean middle = true; 
            boolean right = true;  

            for (int seat : seats) {
                if (seat >= 2 && seat <= 5) {
                    left = false;
                }

                if (seat >= 4 && seat <= 7) {
                    middle = false;
                }

                if (seat >= 6 && seat <= 9) {
                    right = false;
                }
            }

            int groups;

            if (left && right) {
                groups = 2;
            } else if (left || middle || right) {
                groups = 1;
            } else {
                groups = 0;
            }

            answer -= 2;
            answer += groups;
        }

        return answer;
    }
}