class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != 'a' && arr[left] != 'e' && arr[left] != 'i' && arr[left] != 'o' && arr[left] != 'u' && arr[left] != 'A' && arr[left] != 'E' && arr[left] != 'I' && arr[left] != 'O' && arr[left] != 'U') {
                left++;
            } else if (arr[right] != 'a' && arr[right] != 'e' && arr[right] != 'i' && arr[right] != 'o' && arr[right] != 'u' && arr[right] != 'A' && arr[right] != 'E' && arr[right] != 'I' && arr[right] != 'O' && arr[right] != 'U') {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }
}