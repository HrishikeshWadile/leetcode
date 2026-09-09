class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);

        int l = 0, r = nums.length - 1;

        while (l < r) {

            // No negative or no positive number remaining
            if (nums[l] > 0 || nums[r] < 0)
                return -1;

            int d = nums[r] + nums[l];

            if (d == 0)
                return nums[r];
            else if (d > 0)
                r--;
            else
                l++;
        }

        return -1;
    }
}