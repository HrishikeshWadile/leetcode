class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;

        int l = 1, r = num;

        while (l < r) {
            int m = l + (r - l) / 2;
            long o = 1L * m * m;

            if (o == num) return true;
            else if (o > num) r = m;
            else l = m + 1;
        }

        return 1L * l * l == num;
    }
}