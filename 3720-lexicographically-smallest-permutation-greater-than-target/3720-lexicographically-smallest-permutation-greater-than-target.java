class Solution {

    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[26];
        int n = s.length();

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        char[] r = new char[n];

        for (int j = 0; j < n; j++) {

            int c = target.charAt(j) - 'a';

            // Same character available
            if (freq[c] > 0) {
                r[j] = target.charAt(j);
                freq[c]--;
            }

            // Need to make permutation greater
            else {

                int x = c + 1;

                while (x < 26 && freq[x] == 0)
                    x++;

                // If possible, use the smallest greater character
                if (x < 26) {
                    r[j] = (char) (x + 'a');
                    freq[x]--;

                    // Fill remaining characters smallest first
                    j++;
                    int k = 0;

                    while (j < n) {
                        while (freq[k] == 0)
                            k++;

                        r[j++] = (char) (k + 'a');
                        freq[k]--;
                    }

                    return new String(r);
                }

                // No greater character -> backtrack
                while (--j >= 0) {

                    freq[r[j] - 'a']++;

                    c = target.charAt(j) - 'a';
                    x = c + 1;

                    while (x < 26 && freq[x] == 0)
                        x++;

                    if (x < 26) {
                        r[j] = (char) (x + 'a');
                        freq[x]--;

                        j++;
                        int k = 0;

                        while (j < n) {
                            while (freq[k] == 0)
                                k++;

                            r[j++] = (char) (k + 'a');
                            freq[k]--;
                        }

                        return new String(r);
                    }
                }

                return "";
            }
        }

        // Exact match -> backtrack to find next greater
        while (--n >= 0) {

            freq[r[n] - 'a']++;

            int c = target.charAt(n) - 'a';
            int x = c + 1;

            while (x < 26 && freq[x] == 0)
                x++;

            if (x < 26) {
                r[n] = (char) (x + 'a');
                freq[x]--;

                n++;
                int k = 0;

                while (n < s.length()) {
                    while (freq[k] == 0)
                        k++;

                    r[n++] = (char) (k + 'a');
                    freq[k]--;
                }

                return new String(r);
            }
        }

        return "";
    }
}