class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length, k = 0;
        int l1 = nums[0], l2 = nums[1];

        int[] arr2 = new int[n - 1];

        // First element goes to arr1
        // Second element goes to arr2
        arr2[k++] = nums[1];

        for (int i = 2; i < n; i++) {

            if (l1 > l2) {
                l1 = nums[i];

                // Shift current element left by
                // the number of elements in arr2
                nums[i - k] = nums[i];

            } else {
                l2 = nums[i];
                arr2[k++] = nums[i];
            }
        }

        // arr1 occupies nums[0 ... n-k-1]
        // Put arr2 immediately after arr1
        for (int i = 0; i < k; i++) {
            nums[n - k + i] = arr2[i];
        }

        return nums;
    }
}