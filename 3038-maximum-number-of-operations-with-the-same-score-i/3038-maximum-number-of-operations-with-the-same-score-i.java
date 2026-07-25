class Solution {
    public int maxOperations(int[] nums) {
        if (nums.length <= 3) return 1;

        int score = nums[0] + nums[1], c = 1;

        for (int i = 2; i < nums.length - 1; i += 2) {
            if (nums[i] + nums[i + 1] != score)
                return c;
            c++;
        }

        return c;
    }
}