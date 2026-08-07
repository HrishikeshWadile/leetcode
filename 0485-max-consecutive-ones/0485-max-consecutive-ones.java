class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c = 0, m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                c++;
            } else {
                if (c > 0) {
                    m = Math.max(c, m);
                    c = 0;
                }
            }
        }
        return Math.max(c, m);
    }
}