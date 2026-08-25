class Solution {
    public int differenceOfSums(int n, int m) {
        if (n < m) return n * (n + 1) / 2;
        if (m == 1) return -1 * (n * (n + 1) / 2);

        int q = n / m;
        int s = n * (n + 1) / 2;
        int n2 = (q * (q + 1) / 2) * m;

        return s - 2 * n2;
    }
}