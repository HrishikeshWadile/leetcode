class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int l = nums.length, mid = nums[l / 2]; 
        for (int i = 0; i < l; i++) {
            if (i == l / 2) continue;
            if (nums[i] == mid) return false;
        }
        return true;
    }
}