import java.util.Arrays;

class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        int i = m - 2;
        int j = n - 2;
        int hPieces = 1;
        int vPieces = 1;
        int cost = 0;

        while (i >= 0 && j >= 0) {
            if (horizontalCut[i] > verticalCut[j]) {
                cost += horizontalCut[i--] * vPieces;
                hPieces++;
            } else {
                cost += verticalCut[j--] * hPieces;
                vPieces++;
            }
        }

        while (i >= 0) {
            cost += horizontalCut[i--] * vPieces;
        }

        while (j >= 0) {
            cost += verticalCut[j--] * hPieces;
        }

        return cost;
    }
}