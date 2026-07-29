class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        char[] r = new char[n];
        int i = 0;

        for (; i < n / 2; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        if (n % 2 != 0) r[n / 2] = s.charAt(n / 2);

        // feasibility check: total distinct palindromes must be >= k
        long total = count(freq, k);
        if (total < k) return "";

        for (int pos = 0; pos < n / 2; pos++) {
            for (int c = 0; c < 26; c++) {
                if (freq[c] == 0) continue;

                freq[c]--;
                long cnt = count(freq, k);

                if (cnt >= k) {
                    r[pos] = (char) ('a' + c);
                    r[n - 1 - pos] = (char) ('a' + c);
                    break;
                } else {
                    k -= cnt;
                    freq[c]++; // undo, try next character
                }
            }
        }

        return new String(r);
    }

    // number of distinct permutations of remaining multiset, capped at 'limit'
    long count(int[] freq, long limit) {
        int rem = 0;
        for (int f : freq) rem += f;

        long ans = 1;

        for (int f : freq) {
            if (f == 0) continue;
            ans *= nCr(rem, f, limit);
            if (ans >= limit) return limit;
            rem -= f;
        }

        return ans;
    }

    // C(n, r), capped at 'limit' (returns 'limit' if it would exceed it)
    long nCr(int n, int r, long limit) {
        r = Math.min(r, n - r);
        long ans = 1;
        for (int i = 0; i < r; i++) {
            ans = ans * (n - r + i + 1) / (i + 1); // always exact at this point
            if (ans >= limit) return limit;
        }
        return ans;
    }
}