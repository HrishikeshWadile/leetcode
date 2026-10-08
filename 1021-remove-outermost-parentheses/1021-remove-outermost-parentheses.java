class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder(n);

        int c = 0;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '(') {
                c++;

                // Don't add the opening parenthesis
                // when it is the outermost one.
                if (c > 1) {
                    ans.append('(');
                }

            } else {
                c--;

                // Don't add the closing parenthesis
                // when it is the outermost one.
                if (c > 0) {
                    ans.append(')');
                }
            }
        }

        return ans.toString();
    }
}