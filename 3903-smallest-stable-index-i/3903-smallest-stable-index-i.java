class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] rMin = new int[n];
        rMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMin[i] = Math.min(rMin[i + 1], nums[i]);
        }

        int max = -1;

        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
            if (max - rMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}