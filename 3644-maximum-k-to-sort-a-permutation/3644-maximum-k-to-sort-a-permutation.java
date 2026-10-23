class Solution {
    public int sortPermutation(int[] nums) {
        int k = -1, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                if (k == -1) k = nums[i];
                else {
                    k &= nums[i];
                }
            }
            if (k == 0) return 0;
        }
        if (k == -1) return 0; 
        return k;
    }
}