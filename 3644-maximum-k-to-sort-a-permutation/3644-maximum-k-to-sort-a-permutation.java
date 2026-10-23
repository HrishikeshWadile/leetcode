class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length, k = (1 << 17) - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == i) continue;
            k &= i;
        }
        return k == ((1 << 17) - 1) ? 0 : k;
    }
}
