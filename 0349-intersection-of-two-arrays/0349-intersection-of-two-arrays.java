class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] p = new int[1001];

        for (int n : nums1) {
            if (p[n] == 0)
                p[n] = -1;
        }

        int c = 0;
        for (int n : nums2) {
            if (p[n] == -1) {
                c++;
                p[n] = 1;
            }
        }

        int[] inter = new int[c];
        int k = 0;

        for (int i = 0; i <= 1000; i++) {
            if (p[i] == 1) {
                inter[k++] = i;
            }
        }

        return inter;
    }
}