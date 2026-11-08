class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int total = 0, iso = 0;

        boolean[] r = new boolean[m];
        int[] c = new int[n];
        int[] firstRow = new int[n];

        for (int i = 0; i < m; i++) {
            int l = -1;
            boolean firstIso = false;

            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;

                total++;

                // Vertical connection with a previous server
                if (c[j] == 1 && !r[firstRow[j]]) {
                    iso--;
                }

                // First server in the current row
                if (l == -1) {
                    l = j;

                    if (c[j] == 0) {
                        iso++;
                        firstIso = true;
                    }
                }
                // Second server in the current row
                else if (!r[i]) {
                    r[i] = true;

                    if (firstIso) {
                        iso--;
                        firstIso = false;
                    }
                }

                // Store first occurrence of this column
                if (c[j] == 0) {
                    firstRow[j] = i;
                }

                c[j]++;
            }
        }

        return total - iso;
    }
}