class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        if (n == 1) return 0;

        boolean inc;

        // Determine increasing or decreasing circular order
        if (nums[1] == (nums[0] + 1) % n) {
            inc = true;
        } 
        else if (nums[1] == (nums[0] - 1 + n) % n) {
            inc = false;
        } 
        else {
            return -1;
        }

        int zeroPos = -1;
        int maxPos = -1;

        // Validate circular order and record positions in the same traversal
        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                zeroPos = i;
            }

            if (nums[i] == n - 1) {
                maxPos = i;
            }

            if (i > 0) {
                int expected;

                if (inc) {
                    expected = (nums[i - 1] + 1) % n;
                } 
                else {
                    expected = (nums[i - 1] - 1 + n) % n;
                }

                if (nums[i] != expected) {
                    return -1;
                }
            }
        }

        // Increasing case
        if (inc) {
            int direct = zeroPos;
            int reversed = 2 + (n - zeroPos);

            return Math.min(direct, reversed);
        }

        // Decreasing case
        else {
            int direct = maxPos + 1;
            int reversed = 2 + (n - maxPos - 1);

            return Math.min(direct, reversed);
        }
    }
}
