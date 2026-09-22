class Solution {
    public int maxSum(int[] nums, int k, int m) {
        int n = nums.length;

        // Prefix sum
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // dp[i] = maximum sum using current number of subarrays
        // among first i elements
        long[] dp = new long[n + 1];

        // Impossible states
        long NEG = Long.MIN_VALUE / 4;

        for (int i = 0; i <= n; i++) {
            dp[i] = NEG;
        }

        // 0 subarrays -> sum 0
        for (int i = 0; i <= n; i++) {
            dp[i] = 0;
        }

        for (int sub = 1; sub <= k; sub++) {

            long[] next = new long[n + 1];

            for (int i = 0; i <= n; i++) {
                next[i] = NEG;
            }

            // Best value of:
            // dp[start] - prefix[start]
            long best = NEG;

            for (int i = 1; i <= n; i++) {

                // Start of a subarray must satisfy:
                // i - start >= m
                int start = i - m;

                if (start >= 0 && dp[start] != NEG) {
                    best = Math.max(best,
                                    dp[start] - prefix[start]);
                }

                // Option 1:
                // Don't end a subarray at i
                next[i] = next[i - 1];

                // Option 2:
                // End the current subarray at i
                if (best != NEG) {
                    next[i] = Math.max(
                        next[i],
                        prefix[i] + best
                    );
                }
            }

            dp = next;
        }

        return (int) dp[n];
    }
}