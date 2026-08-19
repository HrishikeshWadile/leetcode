class Solution {
    public int smallestIndex(int[] nums) {
        int sum, c;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            c = nums[i];
            while (c > 0) {
                sum += (c % 10);
                c /= 10;
            }
            if (i == sum) return i;
        }
        return -1;
    }
}