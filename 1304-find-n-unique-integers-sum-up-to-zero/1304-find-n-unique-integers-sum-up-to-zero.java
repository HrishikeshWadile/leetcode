class Solution {
    public int[] sumZero(int n) {
        int[] r = new int[n];
        int s = 0 - n / 2;

        for (int i = 0; i < n; i++) {
            if (i == n / 2 && n % 2 == 0) {
                s++;
            }

            r[i] = s++;
        }

        return r;
    }
}