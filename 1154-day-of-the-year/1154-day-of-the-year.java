class Solution {
    public int dayOfYear(String date) {
        String[] arr = date.split("-");
        int month = Integer.parseInt(arr[1]);
        int days = Integer.parseInt(arr[2]);
        int[] mon = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        days += mon[month - 1];
        int year = Integer.parseInt(arr[0]);
        if (month > 2 && (year % 400 == 0 || year % 100 != 0 && year % 4 == 0)) {
            days += 1;
        }
        return days;
    }
}