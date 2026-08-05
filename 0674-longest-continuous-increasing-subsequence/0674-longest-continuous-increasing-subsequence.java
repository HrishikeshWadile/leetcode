class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max = 1, curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) curr++;
            else {
                max = Math.max(max, curr);
                curr = 1;
            }
        }
        return Math.max(max, curr);
    }
}