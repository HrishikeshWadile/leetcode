class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            int max = -1;

            // First pass: find the maximum in the column
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] != -1) {
                    max = Math.max(max, matrix[i][j]);
                }
            }

            // Second pass: replace -1 with the maximum
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = max;
                }
            }
        }

        return matrix;
    }
}