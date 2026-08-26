class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int i = 0, j = 0, c = 0, n = s.length();

        while (i < n && s.charAt(i) == '0') i++;

        j = i;

        while (j < n && c < k) {
            if (s.charAt(j) == '1') c++;
            j++;
        }

        if (c != k) return "";

        if (j - i == k) return s.substring(i, j);

        String r = s.substring(i, j);
        int l = r.length();

        while (j < n) {
            while (j < n && s.charAt(j) == '0') j++;

            if (j == n) break;

            i++;

            while (s.charAt(i) == '0') i++;

            int len = j - i + 1;

            if (len < l) {
                r = s.substring(i, j + 1);
                l = len;

                // Minimum possible length reached
                if (l == k) return r;
            }
            else if (len == l) {
                r = smaller(r, s.substring(i, j + 1), l);
            }

            j++;
        }

        return r;
    }

    String smaller(String a, String b, int n) {
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) > b.charAt(i)) return b;
            if (a.charAt(i) < b.charAt(i)) return a;
        }

        return a;
    }
}