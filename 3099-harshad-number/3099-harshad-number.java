class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int d = x, s = 0;
        while (d > 0) {
            s += d % 10;
            d /= 10;
        }
        if (x % s == 0) return s;
        return -1;
    }
}