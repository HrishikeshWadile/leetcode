class Solution {

    public int kIncreasing(int[] arr, int k) {
        int n = arr.length;
        int operations = 0;

        for (int start = 0; start < k && start < n; start++) {

            // Extract the k-spaced subsequence conceptually:
            // start, start+k, start+2k, ...

            int len = 0;

            for (int i = start; i < n; i += k) {
                len++;
            }

            // tails[j] = smallest possible ending value
            // of a non-decreasing subsequence of length j + 1
            int[] tails = new int[len];
            int size = 0;

            for (int i = start; i < n; i += k) {
                int x = arr[i];

                // For NON-DECREASING subsequence,
                // find first value STRICTLY GREATER than x.
                int left = 0;
                int right = size;

                while (left < right) {
                    int mid = left + (right - left) / 2;

                    if (tails[mid] > x) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }

                tails[left] = x;

                if (left == size) {
                    size++;
                }
            }

            // Everything outside the LNDS must be changed.
            operations += len - size;
        }

        return operations;
    }
}