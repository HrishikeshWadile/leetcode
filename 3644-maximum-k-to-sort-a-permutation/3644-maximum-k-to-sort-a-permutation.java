class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int i = 0;

        // Find the first misplaced element
        while (i < n && nums[i] == i) {
            i++;
        }

        // Already sorted
        if (i == n) {
            return 0;
        }

        // First misplaced element initializes k
        int k = nums[i];
        i++;

        // AND all remaining misplaced elements
        while (i < n) {
            if (nums[i] != i) {
                k &= nums[i];

                if (k == 0) {
                    return 0;
                }
            }
            i++;
        }

        return k;
    }
}