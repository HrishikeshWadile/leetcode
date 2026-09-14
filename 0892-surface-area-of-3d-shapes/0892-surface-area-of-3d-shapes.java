class Solution {
    public int surfaceArea(int[][] grid) {
        int s = 0, n = grid.length, m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int h = grid[i][j];

                if (h == 0) continue;

                s += 2; // top + bottom

                s += Math.max(0, h - get(grid, i - 1, j));
                s += Math.max(0, h - get(grid, i + 1, j));
                s += Math.max(0, h - get(grid, i, j - 1));
                s += Math.max(0, h - get(grid, i, j + 1));
            }
        }

        return s;
    }

    int get(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }

        return grid[i][j];
    }
}