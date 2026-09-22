class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = -1;

            for (int j = 1; j < n; j++) {
                int idx = (i + j) % n;

                if (nums[idx] > nums[i]) {
                    ans[i] = nums[idx];
                    break;
                }
            }
        }

        return ans;
    }
}