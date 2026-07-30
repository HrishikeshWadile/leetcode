class Solution {
    int ans = 0;
    int[] fact = {1, 1, 2, 6, 24, 120, 720, 5040};

    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];

        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }

        int k = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                freq[k++] = freq[i];
            }
        }

        int[] chosen = new int[k];
        dfs(0, freq, chosen, k);

        return ans;
    }

    private void dfs(int idx, int[] freq, int[] chosen, int k) {
        if (idx == k) {
            int len = 0;
            int denom = 1;

            for (int i = 0; i < k; i++) {
                len += chosen[i];
                denom *= fact[chosen[i]];
            }

            if (len > 0) {
                ans += fact[len] / denom;
            }
            return;
        }

        for (int take = 0; take <= freq[idx]; take++) {
            chosen[idx] = take;
            dfs(idx + 1, freq, chosen, k);
        }
    }
}