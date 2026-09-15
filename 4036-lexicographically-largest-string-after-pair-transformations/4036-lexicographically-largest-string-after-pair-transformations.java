class Solution {
    public String[] largestString(int[] nums) {
        int n = nums.length;
        String[] r = new String[n];

        for (int i = 0; i < n; i++) {
            r[i] = create(nums[i]);
        }

        return r;
    }

    String create(int n) {
        char[] r = new char[26];
        int j = 25, i = 25;

        while (i >= 0 && n > 0) {
            if (n % 2 == 1) {
                r[j--] = (char) (25 - i + 'a');
            }

            n /= 2;
            i--;
        }

        if (n != 0) {
            return "zz" + new String(r, j + 1, 25 - j);
        }

        return new String(r, j + 1, 25 - j);
    }
}