class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] > 0 && !visited[r][c]) {

                    long sum = 0;

                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{r, c});
                    visited[r][c] = true;

                    while (!stack.isEmpty()) {

                        int[] curr = stack.pop();
                        int cr = curr[0];
                        int cc = curr[1];

                        sum += grid[cr][cc];

                        for (int d = 0; d < 4; d++) {
                            int nr = cr + dr[d];
                            int nc = cc + dc[d];

                            if (nr >= 0 && nr < m &&
                                nc >= 0 && nc < n &&
                                grid[nr][nc] > 0 &&
                                !visited[nr][nc]) {

                                visited[nr][nc] = true;
                                stack.push(new int[]{nr, nc});
                            }
                        }
                    }

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}