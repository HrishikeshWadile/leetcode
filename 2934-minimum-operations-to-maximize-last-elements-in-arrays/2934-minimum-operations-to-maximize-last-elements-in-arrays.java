class Solution {
    public int minOperations(int[] nums1, int[] nums2) {

        int n = nums1.length;

        int max1 = nums1[n - 1];
        int max2 = nums2[n - 1];

        int max1Swap = nums2[n - 1];
        int max2Swap = nums1[n - 1];

        int op1 = 0;
        int op2 = 1;

        boolean possible1 = true;
        boolean possible2 = true;

        for (int i = 0; i < n - 1; i++) {

            // Last pair NOT swapped
            if (possible1) {
                if (nums1[i] > max1 || nums2[i] > max2) {

                    if (nums2[i] <= max1 && nums1[i] <= max2) {
                        op1++;
                    } else {
                        possible1 = false;
                    }
                }
            }

            // Last pair swapped
            if (possible2) {
                if (nums1[i] > max1Swap || nums2[i] > max2Swap) {

                    if (nums2[i] <= max1Swap && nums1[i] <= max2Swap) {
                        op2++;
                    } else {
                        possible2 = false;
                    }
                }
            }
        }

        if (!possible1 && !possible2)
            return -1;

        if (!possible1)
            return op2;

        if (!possible2)
            return op1;

        return Math.min(op1, op2);
    }
}