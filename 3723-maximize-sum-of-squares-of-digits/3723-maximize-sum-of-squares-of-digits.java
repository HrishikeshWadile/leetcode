class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) return "";

        char[] r = new char[num];
        int i = 0;

        while (i < num && sum >= 9) {
            sum -= 9;
            r[i++] = '9';
        }

        if (i < num) {
            r[i++] = (char) ('0' + sum);
        }

        while (i < num) {
            r[i++] = '0';
        }

        return new String(r);
    }
}