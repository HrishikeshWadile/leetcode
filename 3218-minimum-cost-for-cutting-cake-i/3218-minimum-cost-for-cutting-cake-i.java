class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        for (int i = 0; i < horizontalCut.length / 2; i++) {
            int temp = horizontalCut[i];
            horizontalCut[i] = horizontalCut[horizontalCut.length - 1 - i];
            horizontalCut[horizontalCut.length - 1 - i] = temp;
        }

        for (int i = 0; i < verticalCut.length / 2; i++) {
            int temp = verticalCut[i];
            verticalCut[i] = verticalCut[verticalCut.length - 1 - i];
            verticalCut[verticalCut.length - 1 - i] = temp;
        }
        int i = 0, j = 0, s = 0;
        while (i < m - 1 && j < n - 1) {
            if (horizontalCut[i] > verticalCut[j]) {
                s += horizontalCut[i++] * (j + 1);
            } else {
                s += verticalCut[j++] * (i + 1);
            }
        } while (i < m - 1) {
            s += horizontalCut[i++] * (j + 1);
        } while (j < n - 1) {
            s += verticalCut[j++] * (i + 1);
        }

        return s;
    }
}