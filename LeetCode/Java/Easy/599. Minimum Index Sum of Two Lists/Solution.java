import java.util.*;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        } 

        List<String> result = new ArrayList<>();

        int minSum = Integer.MAX_VALUE;

        for (int j = 0; j < list2.length && j <= minSum; j++) {
            Integer i = map.get(list2[j]);

            if (i != null) {
                int sum = i + j;

                if (sum < minSum) {
                    minSum = sum;
                    result.clear();
                }
                if (sum == minSum) {
                    result.add(list2[j]);
                }
            } 
        }
        return result.toArray(new String[0]);
    }
}