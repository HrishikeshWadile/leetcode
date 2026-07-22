class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int i = 0;
        while (i < n) {
            int correct = nums[i];

            if (correct < n && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i)
                return i;
        }

        return n;
    }
}