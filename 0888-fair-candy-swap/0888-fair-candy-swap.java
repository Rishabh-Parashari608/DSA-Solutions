class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0;
        int sumB = 0;
        for (int x : aliceSizes) {
            sumA += x;
        }
        for (int y : bobSizes) {
            sumB += y;
        }
        int diff = (sumA - sumB) / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int a : aliceSizes) {
            set.add(a);
        }
        for (int b : bobSizes) {
            if (set.contains(b + diff)) {
                return new int[]{b + diff, b};
            }
        }
        return new int[]{};
    }
}