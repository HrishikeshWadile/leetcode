class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        Arrays.sort(pick, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        boolean[] win = new boolean[n];
        int count = 0;

        int player = pick[0][0];
        int color = pick[0][1];
        int same = 0;

        for (int i = 0; i < pick.length; i++) {

            if (pick[i][0] != player || pick[i][1] != color) {
                player = pick[i][0];
                color = pick[i][1];
                same = 0;
            }

            same++;

            if (!win[player] && same > player) {
                win[player] = true;
                count++;
            }
        }

        return count;
    }
}