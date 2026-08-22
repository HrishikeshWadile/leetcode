class Solution {
    public int passThePillow(int n, int time) {

        int q = time / (n - 1);
        int r = time % (n - 1);

        boolean dir = q % 2 == 0;

        if (dir) {
            return r + 1;
        } else {
            return n - r;
        }
    }
}