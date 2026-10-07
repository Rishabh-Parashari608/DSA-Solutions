class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        Integer[] arr = set.toArray(new Integer[0]);
        Arrays.sort(arr, Collections.reverseOrder());
        if (arr.length < 3) {
            return arr[0];
        } else {
            return arr[2];
        }
    }
}