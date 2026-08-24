class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        int sum = 0;
        for (int x : stones) {
            sum += x;
        }

        int diff = sum;

        for (int i = n - 2; i >= 1; i--) {
            sum -= stones[i + 1];
            diff = Math.max(diff, sum - diff);
        }

        return diff;
    }
}