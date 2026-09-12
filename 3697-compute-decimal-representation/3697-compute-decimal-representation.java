class Solution {
    public int[] decimalRepresentation(int n) {
        int d = n, count = 0;

        // Count non-zero place values
        int temp = n;
        int place = 1;

        while (temp > 0) {
            if (temp % 10 != 0) {
                count++;
            }
            temp /= 10;
        }

        int[] r = new int[count];

        // Build result from right to left
        int i = count - 1;

        while (n > 0) {
            int digit = n % 10;

            if (digit != 0) {
                r[i--] = digit * place;
            }

            n /= 10;
            place *= 10;
        }

        return r;
    }
}