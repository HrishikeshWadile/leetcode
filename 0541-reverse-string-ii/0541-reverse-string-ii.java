class Solution {
    public String reverseStr(String s, int k) {
        char[] r = s.toCharArray();
        int n = s.length();

        for (int i = 0; i < n; i += 2 * k) {
            reverse(r, i, Math.min(i + k - 1, n - 1));
        }

        return new String(r);
    }

    void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}