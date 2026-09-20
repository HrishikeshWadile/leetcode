class Solution {
    public int countDigits(int num) {
        int d = num, c = 0;
        while (d > 0) {
            if (num % (d % 10) == 0) c++;
            d /= 10;
        }
        return c;
    }
}