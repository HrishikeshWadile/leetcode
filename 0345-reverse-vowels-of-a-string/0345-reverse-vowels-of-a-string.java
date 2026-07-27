class Solution {
    public String reverseVowels(String s) {
        char[] a = s.toCharArray();
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (!isVowel(a[l])) {
                l++;
            } else if (!isVowel(a[r])) {
                r--;
            } else {
                char t = a[l];
                a[l] = a[r];
                a[r] = t;
                l++;
                r--;
            }
        }

        return new String(a);
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}