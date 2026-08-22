class Solution {
    public boolean checkDivisibility(int n) {
        int r = 0;
        int sum = 0;
        int pr = 1;
        int temp = n;
        while (n > 0) {
            r = n % 10;
            sum = sum + r;
            pr = pr*r;
            n = n / 10;
        }
        if (temp%(sum+pr)==0)
           return true;
        else
           return false;
        
    }
}