class Solution {
    public int countGoodSubstrings(String s) {
        int l = s.length();
        if (l < 3) return 0;
        int t = 2, a = s.charAt(0) - 'a', b = s.charAt(1) - 'a', c = -1, r = 0;
        char curr;
        for (int i = 2; i < l; i++) {
            if (t == 0) {
                a = s.charAt(i) - 'a';
                if (a != b && b != c && c != a) r++;
            } else if (t == 1) {
                b = s.charAt(i) - 'a';
                if (a != b && b != c && c != a) r++;
            } else {
                c = s.charAt(i) - 'a';
                if (a != b && b != c && c != a) r++;
            }
            t = (t + 1) % 3;
        }
        return r;
    }
}