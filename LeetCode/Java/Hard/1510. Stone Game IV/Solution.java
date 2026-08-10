class Solution {
    public boolean winnerSquareGame(int n) {
        int root = (int)Math.sqrt(n);
        if (root * root == n) {
            return true;
        } else {
            return false;
        }
    }
}