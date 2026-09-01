import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != 0) {
                result.add(nums1[i]);
            }
            
        }
        for (int i = 0; i < nums2.length; i++) {
            result.add(nums2[i]);
        }
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            nums1[i] = result.get(i);
        }
        Arrays.sort(nums1);
    }
}