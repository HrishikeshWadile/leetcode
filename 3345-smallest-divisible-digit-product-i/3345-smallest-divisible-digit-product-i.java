class Solution {
    public int smallestNumber(int n, int t) {
        if (n < 10) {
            while (n != 10 && n % t != 0) n++;
            return n;
        }

        if (n % 10 == 0 || t == 1) return n;

        t /= gcd((n / 10) % 10, t);

        if (t == 1) return n;

        int a = (t - (n % 10) % t) % t;

        return (n % 10) + a >= 10 ? (n / 10 + 1) * 10 : n + a;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}