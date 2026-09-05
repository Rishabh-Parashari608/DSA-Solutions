class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        char[] result = new char[word1.length() + word2.length()];

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            result[k++] = arr1[i++];
            result[k++] = arr2[j++];
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return new String(result);
    }
}