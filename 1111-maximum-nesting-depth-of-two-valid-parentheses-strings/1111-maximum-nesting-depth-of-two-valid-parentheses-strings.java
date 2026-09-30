class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int c = 0, n = seq.length();
        char ch;
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            ch = seq.charAt(i);
            if (ch == '(') {
                r[i] = c;
                c = 1 - c;
            } else if (ch == ')') {
                c = 1 - c;
                r[i] = c;
            }
        }
        return r;
    }
}