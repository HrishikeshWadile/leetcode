class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            if (dp[i]) continue;

            for (int j = 1; j * j <= n - i; j++) {
                dp[i + j * j] = true;
            }
        }

        return dp[n];
    }
}