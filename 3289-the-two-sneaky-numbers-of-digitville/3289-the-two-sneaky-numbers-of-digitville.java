class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] r = new int[2];
        int j = 0, n = nums.length, c;
        boolean[] s = new boolean[n];
        for (int i = 0; i < n; i++) {
            c = nums[i];
            if (s[c]) {
                r[j++] = c;
                if (j == 2) return r;
            } else {
                s[c] = true;
            }
        }
        return r;
    }
}