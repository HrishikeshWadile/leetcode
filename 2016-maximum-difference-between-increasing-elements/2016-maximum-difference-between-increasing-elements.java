class Solution {
    public int maximumDifference(int[] nums) {
        int minp = 0, maxp = 0, r = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[minp]) {
                minp = i;
                maxp = i;
            } 
            if (nums[i] > nums[maxp]) {
                maxp = i;
            }

            if (maxp > minp && r < nums[maxp] - nums[minp]) r = nums[maxp] - nums[minp];
        }
        return r;
    }
}