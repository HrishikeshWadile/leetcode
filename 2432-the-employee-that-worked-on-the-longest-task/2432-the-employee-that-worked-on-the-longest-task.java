class Solution {
    public int hardestWorker(int n, int[][] logs) {

        int l = 0;
        int m = -1;
        int e = -1;

        for (int[] log : logs) {
            int duration = log[1] - l;

            if (duration > m || (duration == m && log[0] < e)) {
                m = duration;
                e = log[0];
            }

            l = log[1];
        }

        return e;
    }
}