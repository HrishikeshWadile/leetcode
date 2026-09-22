class Solution {
    public long rob(int[] nums, int[] colors) {
        long ans = 0;
        int n = nums.length;
        int l = 0;

        while (l < n) {
            int color = colors[l];

            long prev2 = 0;
            long prev1 = 0;

            while (l < n && colors[l] == color) {
                long curr = Math.max(prev1, prev2 + nums[l]);

                prev2 = prev1;
                prev1 = curr;

                l++;
            }

            ans += prev1;
        }

        return ans;
    }
}