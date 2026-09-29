class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // A valid parentheses string must have even length.
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // A valid string must start with '(' and end with ')'.
        if (grid[0][0] != '(' || grid[m - 1][n - 1] != ')') {
            return false;
        }

        int maxBalance = m + n - 1;

        // dp[i][j][balance]
        boolean[][][] dp = new boolean[m][n][maxBalance + 1];

        // Starting cell '(' gives balance 1.
        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Skip the starting cell.
                if (i == 0 && j == 0) {
                    continue;
                }

                for (int balance = 0; balance <= maxBalance; balance++) {

                    int newBalance;

                    if (grid[i][j] == '(') {
                        newBalance = balance + 1;
                    } else {
                        newBalance = balance - 1;
                    }

                    // Balance can never become negative.
                    if (newBalance < 0 || newBalance > maxBalance) {
                        continue;
                    }

                    // We can arrive from the top.
                    if (i > 0 && dp[i - 1][j][balance]) {
                        dp[i][j][newBalance] = true;
                    }

                    // Or arrive from the left.
                    if (j > 0 && dp[i][j - 1][balance]) {
                        dp[i][j][newBalance] = true;
                    }
                }
            }
        }

        // Valid parentheses string must finish with balance 0.
        return dp[m - 1][n - 1][0];
    }
}