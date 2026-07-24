class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        boolean[] pair = new boolean[2048];

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                pair[nums[i] ^ nums[j]] = true;
            }
        }

        boolean[] ans = new boolean[2048];
        int ansc = 0, pos;
        for (int x = 0; x < 2048; x++) {
            if (!pair[x]) continue;

            for (int i = 0; i < len; i++) {
                pos = x ^ nums[i];
                if (!ans[pos]) {
                    ansc++;
                    ans[pos] = true;
                }
            }
        }
        return ansc;
    }
}