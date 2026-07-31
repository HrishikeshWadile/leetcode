class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) return "";
        char[] r = palindrome.toCharArray();
        boolean flag = false;

        for (int i = 0; i < r.length / 2; i++) {
            if (r[i] != 'a') {
                r[i] = 'a';
                flag = true;
                break;
            }
        }

        if (!flag) {
            r[r.length - 1] = 'b';
        }

        return new String(r);    
    }
}