class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length];
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i] = nums[i];
            if (nums[i] == k) c++;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                sums[j] += nums[j + i];
                if (sums[j] == k) c++;
            }
        }
        return c;
    }
}