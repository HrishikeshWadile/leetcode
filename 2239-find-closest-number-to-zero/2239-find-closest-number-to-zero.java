class Solution {
    public int findClosestNumber(int[] nums) {
        int r = 100001;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) return 0;
            if (r < 0 && nums[i] == -r) {
                r = -r;
            } else if (Math.abs(nums[i]) < Math.abs(r)) {
                r = nums[i];
            }
        }
        return r;
    }
}