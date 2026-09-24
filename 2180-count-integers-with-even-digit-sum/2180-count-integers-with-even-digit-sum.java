class Solution {
    public int countEven(int num) {
        int d = num, s = 0;
        while (d > 0) {
            s += d % 10;
            d/= 10;
        }
        if (s % 2 == 1) {
            return (num - 1) / 2;
        }
        return num / 2;
    }
}