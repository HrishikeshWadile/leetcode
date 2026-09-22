class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);

        int l = 0;
        int r = nums.length - 1;
        double ans = Double.MAX_VALUE;

        while (l < r) {
            ans = Math.min(ans, (nums[l] + nums[r]) / 2.0);
            l++;
            r--;
        }

        return ans;
    }
}