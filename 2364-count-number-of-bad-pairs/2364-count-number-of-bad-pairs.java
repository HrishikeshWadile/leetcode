class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> d = new HashMap<>();

        long bad = 0;

        for (int i = 0; i < nums.length; i++) {
            int c = nums[i] - i;

            int freq = d.getOrDefault(c, 0);

            bad += i - freq;

            d.put(c, freq + 1);
        }

        return bad;
    }
}