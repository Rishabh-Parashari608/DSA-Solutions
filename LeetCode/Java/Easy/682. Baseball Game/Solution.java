class Solution {
    public int calPoints(String[] operations) {
        int[] record = new int[operations.length];
        int size = 0;

        for (String operation : operations) {
            if (operation.equals("C")) {
                size--;
            } else if (operation.equals("D")) {
                record[size] = record[size - 1] * 2;
                size++;
            } else if (operation.equals("+")) {
                record[size] = record[size - 1] + record[size - 2];
                size++;
            } else {
                record[size] = Integer.parseInt(operation);
                size++;
            }
        }

        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += record[i];
        }

        return sum;
    }
}