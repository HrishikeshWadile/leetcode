class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();

        // Initially, the partition is before index 0.
        // Therefore everything is on the right.
        int rightZeros = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                rightZeros++;
            }
        }

        int leftOnes = 0;
        int ans = rightZeros;

        // Partition between i-1 and i
        for (int i = 0; i < n; i++) {

            // s[i] moves from right side to left side
            if (s.charAt(i) == '0') {
                rightZeros--;
            } else {
                leftOnes++;
            }

            // left -> all 0
            // right -> all 1
            ans = Math.min(ans, leftOnes + rightZeros);
        }

        return ans;
    }
}