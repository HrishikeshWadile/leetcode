class Solution {
    public int minOperations(int[] nums, int k) {
        int o = 0;
        for (int n: nums) if (n < k) o++;
        return o;
    }
}