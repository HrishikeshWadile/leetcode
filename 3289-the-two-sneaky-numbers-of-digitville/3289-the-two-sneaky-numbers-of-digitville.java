class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] r = new int[2];
        Arrays.sort(nums);
        int j = 0, n = nums.length, l = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == l) {
                r[j++] = l;
                System.out.println(l);
                if (j == 2) return r;
            }
            l = nums[i];
        }

        return r;
    }
}