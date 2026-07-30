class Solution {
    public int minimumMoves(String s) {
        int i = 0, c = 0; 
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) != 'X') i++;
            if (i == s.length()) break;
            if (s.charAt(i) == 'X') {
                c++;
                i += 3;
            }
        }
        return c;
    }
}