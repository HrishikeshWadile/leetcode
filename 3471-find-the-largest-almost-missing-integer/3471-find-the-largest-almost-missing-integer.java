class Solution {

    public int largestInteger(int[] nums, int k) {

        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // k == 1
        // Every element forms one subarray.
        if (k == 1) {
            int ans = -1;

            for (int num : nums) {
                if (freq.get(num) == 1) {
                    ans = Math.max(ans, num);
                }
            }

            return ans;
        }

        // k == n
        // There is only one subarray.
        if (k == n) {
            int ans = -1;

            for (int num : nums) {
                ans = Math.max(ans, num);
            }

            return ans;
        }

        int ans = -1;

        // Only endpoints can be almost missing.
        if (freq.get(nums[0]) == 1) {
            ans = Math.max(ans, nums[0]);
        }

        if (freq.get(nums[n - 1]) == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}