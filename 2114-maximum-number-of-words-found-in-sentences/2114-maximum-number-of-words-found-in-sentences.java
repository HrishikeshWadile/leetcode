class Solution {
    public int mostWordsFound(String[] sentences) {
        int c = 0, m = 0;
        for (String s: sentences) {
            c = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') c++;
            }
            m = Math.max(c + 1, m);
        }
        return Math.max(c + 1, m);
    }
}