class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        HashMap<Integer, Integer> fOcc = new HashMap<>();

        int maxF = 0;
        int rl = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            fOcc.putIfAbsent(n, i);
            int c = fOcc.get(n);

            dp[c]++;

            if (dp[c] > maxF) {
                maxF = dp[c];
                rl = i - c + 1;
            } else if (dp[c] == maxF) {
                rl = Math.min(rl, i - c + 1);
            }
        }

        return rl;
    }
}