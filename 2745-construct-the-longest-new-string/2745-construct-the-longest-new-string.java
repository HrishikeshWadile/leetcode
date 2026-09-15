class Solution {
    public int longestString(int x, int y, int z) {
        if (x < y) {
            return (x + Math.min(x + 1, y) + z) * 2;
        } else {
            return (y + Math.min(y + 1, x) + z) * 2;
        }
    }
}