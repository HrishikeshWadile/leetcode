import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int[] diff = new int[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);   // was `diff = ...` (bug)
            total += diff[i];
        }
        if (k >= total) return 0;                      // everything can be zeroed

        Arrays.sort(diff);
        int max = diff[n - 1];
        long mc = 0;                                   // count of elements currently at level `max`
        int i = n - 1;

        for (; i >= 0; i--) {
            mc++;                                      // diff[i] joins the top group
            int next = (i > 0) ? diff[i - 1] : 0;      // next lower level (0 if none)
            long cost = (long) (max - next) * mc;      // cost to bring the group down to `next`
            if (cost <= k) {
                k -= cost;
                max = next;
            } else {
                break;                                 // can't fully drop to `next`
            }
        }

        // mc elements sit at level `max`, k operations remain (k < (max - next) * mc)
        long drop = k / mc;
        long rem = k % mc;
        long level = max - drop;

        // rem elements go to (level - 1), the other (mc - rem) stay at `level`
        long res = rem * (level - 1) * (level - 1)
                 + (mc - rem) * level * level;

        // untouched smaller elements: indices 0..i-1
        for (int j = 0; j < i; j++) {
            res += (long) diff[j] * diff[j];
        }
        return res;
    }
}