class Solution {
    public boolean divideArray(int[] nums) {

        int[] f = new int[501];

        int n = nums.length, min = 501, max = 0;

        for (int i = 0; i < n; i++) {

            f[nums[i]]++;

            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }

        for (int i = min; i <= max; i++) {
            if (f[i] % 2 != 0)
                return false;
        }

        return true;
    }
}