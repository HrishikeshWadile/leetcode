class Solution {
    public String reverseByType(String s) {
        char[] res = s.toCharArray();
        int n = res.length;

        // Reverse lowercase letters
        int l = 0, r = n - 1;

        while (l < r) {
            while (l < r && res[l] >= 'a' && res[l] <= 'z') l++;
            while (l < r && res[r] >= 'a' && res[r] <= 'z') r--;

            if (l < r) {
                char t = res[l];
                res[l] = res[r];
                res[r] = t;
                l++;
                r--;
            }
        }

        // Reverse non-lowercase characters
        l = 0;
        r = n - 1;

        while (l < r) {
            while (l < r && res[l] < 'a' || res[l] > 'z') l++;
            while (l < r && res[r] < 'a' || res[r] > 'z') r--;

            if (l < r) {
                char t = res[l];
                res[l] = res[r];
                res[r] = t;
                l++;
                r--;
            }
        }

        return new String(res);
    }
}