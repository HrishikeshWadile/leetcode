class Solution {
    public int minimumFlips(int n) {
        int p = 0, d = 1;

        while (d <= n) {
            p++;
            d <<= 1;
        }

        int[] b = new int[p];

        for (int i = 0; i < p; i++) {
            b[i] = n & 1;
            n >>= 1;
        }

        int l = 0, r = p - 1;
        int flips = 0;

        while (l < r) {
            if (b[l] != b[r])
                flips += 2;

            l++;
            r--;
        }

        return flips;
    }
}