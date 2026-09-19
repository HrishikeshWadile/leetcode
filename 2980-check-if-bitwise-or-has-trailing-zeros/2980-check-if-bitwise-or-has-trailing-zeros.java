class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int n = nums.length;
        boolean cE = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                if (cE) return true;
                cE = true;
            }
        }
        return false;
    }
}