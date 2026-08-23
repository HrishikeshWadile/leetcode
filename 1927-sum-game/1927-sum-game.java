class Solution {
    public boolean sumGame(String num) {
        int lS = 0, rS = 0;
        int lQC = 0, rQC = 0;

        int n = num.length();
        int i = 0;

        for (; i < n / 2; i++) {
            char c = num.charAt(i);

            if (c == '?')
                lQC++;
            else
                lS += c - '0';
        }

        for (; i < n; i++) {
            char c = num.charAt(i);

            if (c == '?')
                rQC++;
            else
                rS += c - '0';
        }

        if ((lQC + rQC) % 2 == 1)
            return true;

        int diff = lS - rS;
        int qDiff = lQC - rQC;

        return 2 * diff != -9 * qDiff;
    }
}