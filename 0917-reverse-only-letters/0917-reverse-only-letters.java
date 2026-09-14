class Solution {
    public String reverseOnlyLetters(String s) {
        int i = 0, j = s.length() - 1;
        char[] r = s.toCharArray();

        while (i < j) {
            while (i < j && !Character.isLetter(r[i])) i++;
            while (i < j && !Character.isLetter(r[j])) j--;

            if (i < j) {
                char temp = r[i];
                r[i] = r[j];
                r[j] = temp;

                i++;
                j--;
            }
        }

        return new String(r);
    }
}