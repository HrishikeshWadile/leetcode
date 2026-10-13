class Solution {
    public int trailingZeroes(int n) {
        int i = 5, r = 0;
        while (i <= n) {
            r += n / i;
            i *= 5;
        }
        return r;
    }
}