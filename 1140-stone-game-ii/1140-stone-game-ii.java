class Solution {
    public int stoneGameII(int[] piles) {
        int[] suffixSum = Arrays.copyOf(piles, piles.length);

        for (int i = suffixSum.length - 2; i >= 0; i--) {
            suffixSum[i] += suffixSum[i + 1];
        }

        return optimal(suffixSum, 0, 1,new int[piles.length][piles.length]);
    }

    int optimal(int[] sS, int c, int m, int[][] memo) {
        if (c + 2 * m >= sS.length) return sS[c];
        if (memo[c][m] > 0) return memo[c][m];
        int res = Integer.MAX_VALUE;

        for (int i = 1; i <= 2 * m; i++) {
            res = Math.min(res, optimal(sS, c + i, Math.max(i, m), memo));
        }

        memo[c][m] = sS[c] - res;
        return memo[c][m];
    }
}