class Solution {
    public int minimumSwaps(int[] nums) {
        int zc = 0;
        for (int x : nums) {
            if (x == 0) zc++;
        }

        int s = 0;

        if (zc > nums.length / 2) {
            for (int i = 0; i < nums.length - zc; i++) {
                if (nums[i] == 0) s++;
            }
        } else {
            for (int i = nums.length - 1; i >= nums.length - zc; i--) {
                if (nums[i] != 0) s++;
            }
        }

        return s;
    }
}