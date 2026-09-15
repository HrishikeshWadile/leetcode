class Solution {
    public int maxPalindromes(String s, int k) {

        int n = s.length();
        int min = k / 2 + 1;
        int count = 0;

        int i = 0;

        while (i + k <= n) {

            StringBuilder sb = new StringBuilder();
            boolean found = false;

            for (int j = i; j < n && j < i + k + 1; j++) {

                // Insert newest character at the front.
                sb.insert(0, s.charAt(j));

                int len = j - i + 1;

                if (len >= k) {

                    // Latest k characters
                    if (isPalindrome(sb, k)) {
                        count++;
                        i = j + 1;
                        found = true;
                        break;
                    }

                    // Latest k + 1 characters
                    if (len >= k + 1 && isPalindrome(sb, k + 1)) {
                        count++;
                        i = j + 1;
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                i++;
            }
        }

        return count;
    }

    private boolean isPalindrome(StringBuilder sb, int len) {

        for (int i = 0; i < len / 2; i++) {
            if (sb.charAt(i) != sb.charAt(len - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}