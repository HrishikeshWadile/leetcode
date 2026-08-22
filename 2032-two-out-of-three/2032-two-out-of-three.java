class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        int[][] freq = new int[101][2];
        boolean[] added = new boolean[101];

        List<Integer> r = new ArrayList<>();

        for (int n : nums1) {
            if (freq[n][1] != 1) {
                freq[n][0]++;
                freq[n][1] = 1;
            }
        }

        for (int n : nums2) {
            if (freq[n][1] != 2) {
                freq[n][0]++;
                freq[n][1] = 2;
            }

            if (freq[n][0] >= 2 && !added[n]) {
                r.add(n);
                added[n] = true;
            }
        }

        for (int n : nums3) {
            if (freq[n][1] != 3) {
                freq[n][0]++;
                freq[n][1] = 3;
            }

            if (freq[n][0] >= 2 && !added[n]) {
                r.add(n);
                added[n] = true;
            }
        }

        return r;
    }
}