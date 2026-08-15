class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length / 2;
        Set<Integer> set = new HashSet<>();

        for (int num : candyType) {
            set.add(num);
        }
        int m = set.size();
        return Math.min(n, m);
    }
}