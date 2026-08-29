class Solution {

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        // Sorted copy of values
        int[] d = Arrays.copyOf(nums, n);
        Arrays.sort(d);

        // Original indices
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices according to their corresponding values
        Arrays.sort(indices, (a, b) -> Integer.compare(nums[a], nums[b]));

        int start = 0;

        while (start < n) {

            int end = start;

            // Find the group
            while (end + 1 < n &&
                   d[end + 1] - d[end] <= limit) {
                end++;
            }

            int groupSize = end - start + 1;

            // Get original positions of this group
            int[] groupIndices = new int[groupSize];

            for (int i = 0; i < groupSize; i++) {
                groupIndices[i] = indices[start + i];
            }

            // Earliest positions get smallest values
            Arrays.sort(groupIndices);

            for (int i = 0; i < groupSize; i++) {
                nums[groupIndices[i]] = d[start + i];
            }

            start = end + 1;
        }

        return nums;
    }
}