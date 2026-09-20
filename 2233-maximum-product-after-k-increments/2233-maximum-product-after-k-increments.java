class Solution {
    public int maximumProduct(int[] nums, int k) {
        final long MOD = 1_000_000_007L;

        int min = nums[0];
        int max = nums[0];

        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        // min is the base, so we only store max - min + 1 cells
        int[] freq = new int[max - min + 1];

        for (int x : nums) {
            freq[x - min]++;
        }

        int n = nums.length;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) continue;

            int count = freq[i];
            int value = min + i;

            // Find the next value that actually exists
            int j = i + 1;
            while (j < freq.length && freq[j] == 0) {
                j++;
            }

            // No next group -> all remaining elements have same value
            if (j == freq.length) {
                long add = k / count;
                int extra = k % count;

                long a = value + add;
                long b = a + 1;

                long ans = 1;

                for (int x = 0; x < count - extra; x++) {
                    ans = ans * a % MOD;
                }

                for (int x = 0; x < extra; x++) {
                    ans = ans * b % MOD;
                }

                return (int) ans;
            }

            int nextValue = min + j;

            // Cost to bring the entire current group to nextValue
            long cost = (long) (nextValue - value) * count;

            if (k < cost) {
                // Cannot reach the next group.
                // Distribute k as evenly as possible.
                long add = k / count;
                int extra = k % count;

                long a = value + add;
                long b = a + 1;

                long ans = 1;

                // Current group after distributing k
                for (int x = 0; x < count - extra; x++) {
                    ans = ans * a % MOD;
                }

                for (int x = 0; x < extra; x++) {
                    ans = ans * b % MOD;
                }

                // All groups above the current one remain unchanged
                for (int p = j; p < freq.length; p++) {
                    if (freq[p] == 0) continue;

                    long v = min + p;

                    for (int x = 0; x < freq[p]; x++) {
                        ans = ans * v % MOD;
                    }
                }

                return (int) ans;
            }

            // We can completely raise this group to nextValue
            k -= (int) cost;

            freq[j] += count;
            freq[i] = 0;
        }

        return 0;
    }
}