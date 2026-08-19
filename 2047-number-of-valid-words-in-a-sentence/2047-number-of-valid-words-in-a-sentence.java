
class Solution {
    public int countValidWords(String sentence) {

        int n = sentence.length();
        int i = 0;
        int result = 0;

        while (i < n) {

            // Skip spaces
            while (i < n && sentence.charAt(i) == ' ')
                i++;

            if (i == n)
                break;

            boolean valid = true;
            int hyphenCount = 0;
            int punctuationCount = 0;

            // Process one token
            while (i < n && sentence.charAt(i) != ' ') {

                char c = sentence.charAt(i);

                // Digits are never allowed
                if (c >= '0' && c <= '9') {
                    valid = false;
                }

                // Hyphen
                if (c == '-') {
                    hyphenCount++;

                    // At most one hyphen
                    if (hyphenCount > 1) {
                        valid = false;
                    }

                    // Must be surrounded by lowercase letters
                    if (i == 0 || i + 1 >= n ||
                        sentence.charAt(i - 1) < 'a' ||
                        sentence.charAt(i - 1) > 'z' ||
                        sentence.charAt(i + 1) < 'a' ||
                        sentence.charAt(i + 1) > 'z') {
                        valid = false;
                    }
                }

                // Punctuation
                if (c == '!' || c == '.' || c == ',') {
                    punctuationCount++;

                    // At most one punctuation
                    if (punctuationCount > 1) {
                        valid = false;
                    }

                    // Must be the last character of the token
                    if (i + 1 < n && sentence.charAt(i + 1) != ' ') {
                        valid = false;
                    }
                }

                i++;
            }

            if (valid)
                result++;
        }

        return result;
    }
}
