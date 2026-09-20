class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;

        long[][] dp = new long[m][n];

        // First row
        for (int c = 0; c < n; c++) {
            dp[0][c] = points[0][c];
        }

        for (int r = 1; r < m; r++) {

            long[] left = new long[n];
            long[] right = new long[n];

            left[0] = dp[r - 1][0];

            for (int c = 1; c < n; c++) {
                left[c] = Math.max(
                    dp[r - 1][c],
                    left[c - 1] - 1
                );
            }

            right[n - 1] = dp[r - 1][n - 1];

            for (int c = n - 2; c >= 0; c--) {
                right[c] = Math.max(
                    dp[r - 1][c],
                    right[c + 1] - 1
                );
            }

            for (int c = 0; c < n; c++) {
                dp[r][c] = points[r][c] +
                           Math.max(left[c], right[c]);
            }
        }

        long ans = 0;

        for (int c = 0; c < n; c++) {
            ans = Math.max(ans, dp[m - 1][c]);
        }

        return ans;
    }
}