import java.util.Arrays;

class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int curr = 0, count = 0, s = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == curr) {
                count++;
                if (count > k) {
                    s++;
                }
            } else {
                count = 1;
                curr = nums[i];
            }

            if (s > 0) {
                nums[i - s] = nums[i];
            }
        }

        return Arrays.copyOf(nums, nums.length - s);
    }
}