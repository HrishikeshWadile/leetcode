class Solution {
    public int arrayPairSum(int[] nums) {
        int max = nums[0], min = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (max < nums[i]) max = nums[i];
            if (min > nums[i]) min = nums[i];
        }

        int l = max - min + 1;
        int[] c = new int[l];

        for (int i = 0; i < n; i++) {
            c[nums[i] - min]++;
        }

        int sum = 0;
        boolean s = false;

        for (int k = 0; k < l; k++) {
            if (c[k] != 0) {
                int a = c[k];

                if (s) a--;

                sum += ((a + 1) / 2) * (k + min);

                s = a % 2 == 1;
            }
        }

        return sum;
    }
}