class Solution {
    public int[] findDegrees(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, c = 0;
        int[] r = new int[m];
        for (int i = 0; i < m; i++) {
            c = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) c++;
            }
            r[i] = c;
        }
        return r;
    }
}