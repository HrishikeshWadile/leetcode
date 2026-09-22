class Solution {
    public int maximumSum(int[] nums) {
        Arrays.sort(nums);

        int[][] r = new int[3][3];
        int j = 0, k = 0, l = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int rem = nums[i] % 3;

            if (rem == 0 && j < 3)
                r[0][j++] = nums[i];
            else if (rem == 1 && k < 3)
                r[1][k++] = nums[i];
            else if (rem == 2 && l < 3)
                r[2][l++] = nums[i];
        }

        int ans = 0;

        if (j == 3)
            ans = Math.max(ans, r[0][0] + r[0][1] + r[0][2]);

        if (k == 3)
            ans = Math.max(ans, r[1][0] + r[1][1] + r[1][2]);

        if (l == 3)
            ans = Math.max(ans, r[2][0] + r[2][1] + r[2][2]);

        if (j > 0 && k > 0 && l > 0)
            ans = Math.max(ans, r[0][0] + r[1][0] + r[2][0]);

        return ans;
    }
}