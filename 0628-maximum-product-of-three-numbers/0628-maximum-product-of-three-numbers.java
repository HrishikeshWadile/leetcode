class Solution {
    public int maximumProduct(int[] nums) {
        int n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE;
        int p1 = Integer.MIN_VALUE, p2 = Integer.MIN_VALUE, p3 = Integer.MIN_VALUE;

        for (int num : nums) {
            // Two smallest numbers
            if (num <= n1) {
                n2 = n1;
                n1 = num;
            } else if (num < n2) {
                n2 = num;
            }

            // Three largest numbers
            if (num >= p1) {
                p3 = p2;
                p2 = p1;
                p1 = num;
            } else if (num >= p2) {
                p3 = p2;
                p2 = num;
            } else if (num > p3) {
                p3 = num;
            }
        }

        return Math.max(n1 * n2 * p1, p1 * p2 * p3);
    }
}