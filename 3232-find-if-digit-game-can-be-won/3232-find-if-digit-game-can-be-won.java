class Solution {
    public boolean canAliceWin(int[] nums) {
        int sS = 0, sD = 0;
        for (int n: nums) {
            if (n < 10) sS += n;
            else sD += n;
        }
        return sS != sD;
    }
}