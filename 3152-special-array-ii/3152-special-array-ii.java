class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            if ((nums[i] & 1) != (nums[i - 1] & 1)) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = i;
            }
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            ans[i] = dp[l] == dp[r];
        }

        return ans;
    }
}