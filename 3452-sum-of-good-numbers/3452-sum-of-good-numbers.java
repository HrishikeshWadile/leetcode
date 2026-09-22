class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {

        int n = nums.length, c = 0;
        boolean a, b;

        for (int i = 0; i < n; i++) {

            a = true;
            b = true;

            if (i - k >= 0)
                if (nums[i] <= nums[i - k])
                    a = false;

            if (i + k < n)
                if (nums[i] <= nums[i + k])
                    b = false;

            if (a && b)
                c += nums[i];
        }

        return c;
    }
}