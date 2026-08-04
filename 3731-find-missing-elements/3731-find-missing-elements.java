class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length, min = 101, max = 0;
        boolean[] p = new boolean[100];

        for (int i = 0; i < n; i++) {
            p[nums[i] - 1] = true;
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        List<Integer> r = new ArrayList<>();
        for (int i = min; i < max; i++) {
            if (!p[i - 1]) r.add(i);
        }

        return r;
    }
}