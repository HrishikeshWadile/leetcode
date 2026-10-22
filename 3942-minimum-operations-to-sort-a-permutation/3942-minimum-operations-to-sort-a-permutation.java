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

        // Check whether the whole array follows the circular order
        for (int i = 1; i < n; i++) {
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

        // Increasing case
        if (inc) {
            // Find position of 0
            int pos = 0;

            while (nums[pos] != 0) {
                pos++;
            }

            // Case 1: 0 is brought to front directly
            int direct = pos;

            // Case 2: reverse -> left shift -> reverse
            int reversed = 2 + (n - pos);

            return Math.min(direct, reversed);
        }

        // Decreasing case
        else {
            // Find position of maximum
            int pos = 0;

            while (nums[pos] != n - 1) {
                pos++;
            }

            // Case 3: left shifts + reverse
            int direct = pos + 1;

            // Case 4: reverse + left shifts + one more shift
            int reversed = 2 + (n - pos - 1);

            return Math.min(direct, reversed);
        }
    }
}