class Solution {
    public int minimumOperations(int[][] grid) {
        int m = grid.length, n = grid[0].length, r = 0, l;

        for (int j = 0; j < n; j++) {
            l = grid[0][j] + 1;
            for (int i = 1; i < m; i++) {
                if (grid[i][j] < l) {
                    r += l - grid[i][j];
                    l++;
                } else {
                    l = grid[i][j] + 1;
                }
            }
        }
        return r;
    }
}