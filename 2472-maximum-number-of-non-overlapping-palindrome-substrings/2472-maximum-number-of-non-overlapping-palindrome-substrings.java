class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int count = 0;

        int i = 0;

        while (i + k <= n) {

            int min = k / 2 + 1;

            char[] cQ = new char[min];

            /*
             * Fill the queue with the first required characters.
             */
            for (int j = 0; j < min; j++) {
                cQ[j] = s.charAt(i + j);
            }

            boolean[] state = {true, true};

            /*
             * --------------------------------------------------
             * Check k and k + 1 simultaneously.
             * --------------------------------------------------
             */

            int pairsK = k / 2;
            int pairsK1 = (k + 1) / 2;

            /*
             * k palindrome
             */
            for (int p = 0; p < pairsK; p++) {

                int left = i + p;
                int right = i + k - 1 - p;

                if (s.charAt(left) != s.charAt(right)) {
                    state[0] = false;
                    break;
                }
            }

            /*
             * k + 1 palindrome
             */
            if (i + k + 1 <= n) {

                for (int p = 0; p < pairsK1; p++) {

                    int left = i + p;
                    int right = i + k - p;

                    if (s.charAt(left) != s.charAt(right)) {
                        state[1] = false;
                        break;
                    }
                }

            } else {
                state[1] = false;
            }

            /*
             * Prefer k.
             */
            if (state[0]) {
                count++;
                i += k;
            }
            else if (state[1]) {
                count++;
                i += k + 1;
            }
            else {
                i++;
            }
        }

        return count;
    }
}