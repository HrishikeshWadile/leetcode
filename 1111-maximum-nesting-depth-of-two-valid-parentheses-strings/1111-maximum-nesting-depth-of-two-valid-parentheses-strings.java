class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int c = 0, n = seq.length();
        char ch;
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            ch = seq.charAt(i);
            if (ch == '(') {
                r[i] = c % 2;
                c++;
            } else if (ch == ')') {
                c--;
                r[i] = c % 2;
            }
        }
        return r;
    }
}