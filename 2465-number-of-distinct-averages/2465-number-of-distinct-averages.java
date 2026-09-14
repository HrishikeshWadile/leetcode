class Solution {
    public int distinctAverages(int[] nums) {
        HashSet<Double> o = new HashSet<>();
        Arrays.sort(nums);

        int n = nums.length;
        int c = 0;

        for (int i = 0; i < n / 2; i++) {
            double a = (nums[i] + nums[n - 1 - i]) / 2.0;

            if (o.contains(a)) {
                continue;
            }

            o.add(a);
            c++;
        }

        return c;
    }
}