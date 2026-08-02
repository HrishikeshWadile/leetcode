class Solution {
    public int minOperations(int[] nums) {
        int rc = nums[0] + 1, o = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > rc) {
                rc = nums[i] + 1;
            } else {
                o += rc - nums[i];
                rc++;
            }
        }
        return o;
    }

}