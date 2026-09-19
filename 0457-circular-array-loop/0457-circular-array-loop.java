class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        int[] g = new int[n];

        for (int i = 0; i < n; i++) {
            if (g[i] != 0) continue;

            int j = i;
            int dir = nums[i] > 0 ? 1 : -1;

            while (true) {
                // Direction changed
                if (nums[j] * dir <= 0) break;

                int next = ((j + nums[j]) % n + n) % n;

                // Self-loop
                if (next == j) break;

                // Cycle in current traversal
                if (g[next] == i + 1) return true;

                // Merged into previous traversal
                if (g[next] != 0) break;

                g[j] = i + 1;
                j = next;
            }
        }

        return false;
    }
}