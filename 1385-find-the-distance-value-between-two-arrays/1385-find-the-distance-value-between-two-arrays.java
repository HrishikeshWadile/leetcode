import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int ans = 0;

        for (int x : arr1) {

            // Find first position where arr2[pos] >= x
            int left = 0;
            int right = arr2.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (arr2[mid] >= x) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            int pos = left;

            boolean valid = true;

            // Check arr2[pos] -> first value >= x
            if (pos < arr2.length && Math.abs(arr2[pos] - x) <= d) {
                valid = false;
            }

            // Check arr2[pos - 1] -> largest value < x
            if (pos > 0 && Math.abs(arr2[pos - 1] - x) <= d) {
                valid = false;
            }

            if (valid) {
                ans++;
            }
        }

        return ans;
    }
}