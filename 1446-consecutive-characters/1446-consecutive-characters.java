class Solution {
    public int maxPower(String s) {
        int c = 1, m = 1;
        char ch = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                c++;
            } else {
                ch = s.charAt(i);
                m = Math.max(c, m);
                c = 1;
            }
        }
        return Math.max(c, m);
    }
}