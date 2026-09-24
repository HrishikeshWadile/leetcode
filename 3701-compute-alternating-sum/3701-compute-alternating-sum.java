class Solution {
    public int alternatingSum(int[] nums) {
        int s = 0, n = nums.length;
        boolean o = false;
        for (int i = 0; i < n; i++) {
            if (o) s -= nums[i];
            else s += nums[i];
            o = !o;
        }
        return s;
    }
}