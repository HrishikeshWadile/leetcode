class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;

        // Cycle sort multiples of k
        for (int i = 0; i < n; i++) {
            while (nums[i] % k == 0) {
                int pos = nums[i] / k - 1;

                if (pos < 0 || pos >= n || nums[pos] == nums[i]) {
                    break;
                }

                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
            }
        }

        // Find first missing multiple
        for (int i = 0; i < n; i++) {
            if (nums[i] != (i + 1) * k) {
                return (i + 1) * k;
            }
        }

        return (n + 1) * k;
    }
}