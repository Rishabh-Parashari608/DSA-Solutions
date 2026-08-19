class Solution {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;
        int wealth = 0;
        
        int richest = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                wealth += accounts[i][j];
            }
            richest = Math.max(richest, wealth);
            wealth = 0;
        }
        return richest;
    }
}