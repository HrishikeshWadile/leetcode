class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        long x = 0;
        long MOD = 1_000_000_007L;
        int bitA, bitB;
        for (int i = n - 1; i >= 0; i--) {
            bitA = (int) ((a >> i) & 1);
            bitB = (int) ((b >> i) & 1);
            if (bitA == 0 && bitB == 0) {
                x |= (1L << i);
            } else if ((bitA == 0 && bitB == 1) || (bitA == 1 && bitB == 0)) {
                long x1 = x | (1L << i);
                long diff0 = Math.abs((a ^ x) - (b ^ x));
                long diff1 = Math.abs((a ^ x1) - (b ^ x1));
                if (diff1 < diff0) {
                    x = x1;
                }
            }
        }

        long p = (a ^ x) % MOD;
        long q = (b ^ x) % MOD;

        return (int) ((p * q) % MOD);
    }
}