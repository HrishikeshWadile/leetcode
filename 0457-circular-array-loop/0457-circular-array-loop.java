class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        int[] g = new int[n];

        for (int i = 0; i < n; i++) {
            if (g[i] != 0) continue;

            int j = i;
            int dir = nums[i] > 0 ? 1 : -1;

            while (true) {
                if (nums[j] * dir <= 0) break;

                int next = ((j + nums[j]) % n + n) % n;

                // Single-element loop
                if (next == j) break;

                // Already visited in this traversal
                if (g[next] == i + 1) return true;

                // Already processed by another traversal
                if (g[next] != 0) break;

                g[j] = i + 1;
                j = next;
            }

            // Mark the remaining path as processed
            j = i;

            while (g[j] == i + 1) {
                int next = ((j + nums[j]) % n + n) % n;
                g[j] = -g[j];
                j = next;

                if (next == j) break;
            }
        }

        return false;
    }
}