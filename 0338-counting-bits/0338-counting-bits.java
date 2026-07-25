class Solution {
    public int[] countBits(int n) {
        int[] r = new int[n + 1];
        r[0] = 0;
        int p = 1, k = 1;
        while (p <= n && k <= n) {
            int i = 0;
            while (i < p && k <= n) {
                r[k] = r[i] + 1;
                i++;
                k++;
            }
            p = p << 1;
        }
        return r;
    }
}