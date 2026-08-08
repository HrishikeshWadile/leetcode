class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // bwd[i] = maximum number of characters from the
        // suffix of word2 that can be matched using word1[i...].
        int[] bwd = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }

            bwd[i] = m - 1 - j;
        }

        int[] ans = new int[m];

        int pos = 0;
        boolean changed = false;

        for (int i = 0; i < n && pos < m; i++) {

            /*
             * If only one character of word2 remains,
             * the current position can always be used.
             *
             * This handles cases like:
             *
             * word1 = "ghhgghhhhhh"
             * word2 = "gg"
             *
             * after selecting index 0, index 1 is immediately
             * selected instead of waiting for index 3.
             */
            if (!changed && pos == m - 1) {
                ans[pos] = i;
                return ans;
            }

            /*
             * Exact match.
             */
            if (word1.charAt(i) == word2.charAt(pos)) {
                ans[pos++] = i;
                continue;
            }

            /*
             * Current character can be the one allowed mismatch.
             *
             * We need the rest of word2 to be matched after i.
             */
            if (!changed &&
                bwd[i + 1] >= m - pos - 1) {

                return computeWithMismatch(
                    word1,
                    word2,
                    i,
                    ans,
                    pos
                );
            }
        }

        return new int[0];
    }

    private int[] computeWithMismatch(
            String word1,
            String word2,
            int mismatch,
            int[] ans,
            int pos) {

        /*
         * Prefix before mismatch has already been selected
         * by the forward traversal.
         */
        ans[pos++] = mismatch;

        /*
         * Match the remaining suffix exactly.
         */
        for (int i = mismatch + 1;
             i < word1.length() && pos < word2.length();
             i++) {

            if (word1.charAt(i) == word2.charAt(pos)) {
                ans[pos++] = i;
            }
        }

        /*
         * The backward condition guaranteed that the suffix
         * is possible.
         */
        if (pos == word2.length()) {
            return ans;
        }

        return new int[0];
    }
}