class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length, n = mat[0].length, s = 0, c;
        int[] r = new int[2];
        for (int i = 0; i < m; i++) {
            c = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) c++;
            }

            if (s < c) {
                s = c;
                r[0] = i;
                r[1] = s;
            }
        }
        return r;
    }
}
