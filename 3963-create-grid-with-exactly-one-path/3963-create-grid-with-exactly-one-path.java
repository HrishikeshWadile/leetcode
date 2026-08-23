class Solution {
    public String[] createGrid(int m, int n) {
        String[] r = new String[m];
        char[] s = new char[n];
        Arrays.fill(s, '.');
        r[0] = new String(s);

        for (int i = 0; i < n - 1; i++) s[i] = '#';

        String st = new String(s);

        for (int i = 1; i < m; i++) r[i] = st;
        return r;
    }
}