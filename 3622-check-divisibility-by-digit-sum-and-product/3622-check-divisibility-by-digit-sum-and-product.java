class Solution {
    public boolean checkDivisibility(int n) {
        int d = n, sum = 0, prod = 1;
        while (d > 0) {
            sum += d % 10;
            prod *= d % 10;
            d /= 10;
        }
        return n % (sum + prod) == 0;
    }
}