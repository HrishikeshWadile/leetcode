class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 1;

        while (i < heights.length) {
            if (heights[i - 1] < heights[i]) {
                pq.offer(heights[i] - heights[i - 1]);

                if (pq.size() > ladders) {
                    bricks -= pq.poll();
                }

                if (bricks < 0) {
                    return i - 1;
                }
            }

            i++;
        }

        return heights.length - 1;
    }
}