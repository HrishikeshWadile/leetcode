class Solution {
    public int maxScore(String s) {
        int n = s.length();

        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }

        int leftZeros = 0;
        int rightOnes = totalOnes;
        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }

            ans = Math.max(ans, leftZeros + rightOnes);
        }

        return ans;
    }
}