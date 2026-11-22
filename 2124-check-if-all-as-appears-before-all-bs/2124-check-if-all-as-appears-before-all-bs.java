class Solution {
    public boolean checkString(String s) {
        int i = 0, l = s.length();
        while (i < l && s.charAt(i) == 'a') i++;
        while (i < l && s.charAt(i) == 'b') i++;
        return i == l;
    }
}