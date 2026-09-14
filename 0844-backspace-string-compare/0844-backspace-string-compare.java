class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder a = build(s);
        StringBuilder b = build(t);

        return a.toString().equals(b.toString());
    }

    StringBuilder build(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }

        return sb;
    }
}