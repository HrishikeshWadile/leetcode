class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length, sum = 0;
        int[] freq = new int[100];
        for (int i = 0; i < n; i++) freq[nums[i] - 1]++;

        for (int i = 0; i < 100; i++) if (freq[i] > 1) sum += (freq[i] - 1) * freq[i] / 2;
        return sum;
    }
}