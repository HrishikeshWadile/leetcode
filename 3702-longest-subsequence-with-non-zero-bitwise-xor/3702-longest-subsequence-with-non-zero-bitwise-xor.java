class Solution {
    public int longestSubsequence(int[] nums) {
        int x = 0, nz = 0;

        for (int n : nums) {
            x ^= n;
            if (n > 0 && nz == 0) nz++;
        }

        if (x != 0) return nums.length;
        else if (nz > 0) return nums.length - 1;
        else return 0;
    }
}