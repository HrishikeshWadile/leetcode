class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int one = -1, two = -1, min = 101;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                one = i;
                if (two != -1) {
                    min = Math.min(min, Math.abs(one - two));
                }
            } if (nums[i] == 2) {
                two = i;
                if (one != -1) {
                    min = Math.min(min, Math.abs(one - two));
                }
            }
        }
        if (min == 101) return -1;
        return min;
    }
}