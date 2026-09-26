class Solution {
    double radius;
    double xCenter;
    double yCenter;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
    }
    
    public double[] randPoint() {
        while(true) {
            double x = xCenter - radius + Math.random() * 2 * radius;
            double y = yCenter - radius + Math.random() * 2 * radius;

            double dx = x - xCenter;
            double dy = y - yCenter;

            if (dx * dx + dy * dy <= radius * radius) {
                return new double[]{x, y};
            }
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */