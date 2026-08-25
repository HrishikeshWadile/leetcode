class Solution {
    public String reverseWords(String s) {
        int i = s.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 && s.charAt(i) == ' ') i--;

        while (i >= 0) {
            int end = i + 1;

            while (i >= 0 && s.charAt(i) != ' ') i--;

            sb.append(s.substring(i + 1, end));

            while (i >= 0 && s.charAt(i) == ' ') i--;

            if (i >= 0) sb.append(' ');
        }

        return sb.toString();
    }
}