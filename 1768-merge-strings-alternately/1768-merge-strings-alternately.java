class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        char[] r = new char[l1 + l2];

        int i = 0, k = 0;
        while (i < l1 && i < l2) {
            r[k++] = word1.charAt(i);
            r[k++] = word2.charAt(i);
            i++;
        } 
        while (i < l1) {
            r[k++] = word1.charAt(i);
            i++;
        }
        while (i < l2) {
            r[k++] = word2.charAt(i);
            i++;
        }
        return new String(r);
    }
}