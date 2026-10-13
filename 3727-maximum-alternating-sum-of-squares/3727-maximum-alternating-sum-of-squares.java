class Solution {

    public long maxAlternatingSum(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);

        int n = nums.length;
        long s = 0;

        for (int i = 0; i < n / 2; i++) {
            s -= (long) nums[i] * nums[i];
            s += (long) nums[n - 1 - i] * nums[n - 1 - i];
        }

        if (n % 2 == 1) {
            s += (long) nums[n / 2] * nums[n / 2];
        }

        return s;
    }

    private void mergeSort(int[] nums, int l, int r) {

        if (l >= r) return;

        int mid = l + (r - l) / 2;

        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {

        int[] temp = new int[r - l + 1];

        int i = l;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= r) {

            if (Math.abs(nums[i]) <= Math.abs(nums[j])) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= r) {
            temp[k++] = nums[j++];
        }

        for (i = 0; i < temp.length; i++) {
            nums[l + i] = temp[i];
        }
    }
}