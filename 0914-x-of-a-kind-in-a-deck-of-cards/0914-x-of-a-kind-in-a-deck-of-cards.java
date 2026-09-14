class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : deck) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int freq = 0;

        for (int x : map.values()) {
            freq = gcd(freq, x);
        }

        return freq >= 2;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}