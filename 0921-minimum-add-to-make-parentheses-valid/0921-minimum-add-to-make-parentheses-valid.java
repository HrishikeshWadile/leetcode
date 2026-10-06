class Solution {
    public int minAddToMakeValid(String s) {

        int d = 0, n = s.length(), m = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                d++;
            } else {
                d--;
            }

            m = Math.min(m, d);
        }

        return d - 2 * m;
    }
}