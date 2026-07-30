class Solution {
    public int removeDuplicates(int[] nums) {
        int s = 0, c = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                c++;
                if (c > 2) {
                    s++;
                } else if (s > 0) {
                    nums[i - s] = nums[i];
                }
            } else {
                if (s != 0) {
                    nums[i - s] = nums[i];
                }
                c = 1;
            }
        }
        return nums.length - s;
    }
}