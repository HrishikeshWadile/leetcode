class Solution {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Arrays.sort(reservedSeats,
            Comparator.comparingInt((int[] a) -> a[0])
                      .thenComparingInt(a -> a[1])
        );

        int ans = 0;
        int i = 0;
        int previousRow = 0;

        while (i < reservedSeats.length) {

            int row = reservedSeats[i][0];

            // Every completely empty row has 2 families
            ans += (row - previousRow - 1) * 2;

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            while (i < reservedSeats.length && reservedSeats[i][0] == row) {

                int seat = reservedSeats[i][1];

                if (seat >= 2 && seat <= 5)
                    left = false;

                if (seat >= 4 && seat <= 7)
                    middle = false;

                if (seat >= 6 && seat <= 9)
                    right = false;

                i++;
            }

            if (left && right) {
                ans += 2;
            } else if (left || middle || right) {
                ans += 1;
            }

            previousRow = row;
        }

        // Empty rows after the last reserved row
        ans += (n - previousRow) * 2;

        return ans;
    }
}