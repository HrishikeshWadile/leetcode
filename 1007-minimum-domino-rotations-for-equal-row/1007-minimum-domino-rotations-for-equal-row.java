class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {

        int candidate1 = tops[0];
        int candidate2 = bottoms[0];

        // For candidate1
        int top1 = 0;
        int bottom1 = 0;

        // For candidate2
        int top2 = 0;
        int bottom2 = 0;

        boolean alive1 = true;
        boolean alive2 = true;

        for (int i = 0; i < tops.length; i++) {

            // Candidate 1
            if (alive1) {

                if (tops[i] == candidate1) {
                    // top already correct
                } else if (bottoms[i] == candidate1) {
                    top1++;
                } else {
                    alive1 = false;
                }

                if (bottoms[i] == candidate1) {
                    // bottom already correct
                } else if (tops[i] == candidate1) {
                    bottom1++;
                }
            }

            // Candidate 2
            if (alive2) {

                if (tops[i] == candidate2) {
                    // top already correct
                } else if (bottoms[i] == candidate2) {
                    top2++;
                } else {
                    alive2 = false;
                }

                if (bottoms[i] == candidate2) {
                    // bottom already correct
                } else if (tops[i] == candidate2) {
                    bottom2++;
                }
            }

            if (!alive1 && !alive2) {
                return -1;
            }
        }

        int ans = Integer.MAX_VALUE;

        if (alive1) {
            ans = Math.min(ans, Math.min(top1, bottom1));
        }

        if (alive2) {
            ans = Math.min(ans, Math.min(top2, bottom2));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}