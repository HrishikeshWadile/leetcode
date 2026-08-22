class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        int n = s.length();
        char l = s.charAt(n - 1), c;
        for (int i = n - 2; i >= 0; i--) {
            c = s.charAt(i);
            if (Math.abs(l - c) > 2) return false;
            l = c;
        }
        return true;
    }
}