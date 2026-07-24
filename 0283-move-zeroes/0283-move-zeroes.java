class Solution {
    public void moveZeroes(int[] nums) {
        int zc = 0, i = 0;
        for (; i < nums.length - zc; i++) {
            if (nums[i] == 0) zc++;
            else nums[i - zc] = nums[i];
        }
        for (; i < nums.length; i++) {
            if (nums[i] == 0) {
                zc++;
                nums[nums.length - zc] = 0;
            } else {
                nums[i - zc] = nums[i];
                nums[i] = 0;
            }
        }
    }
}