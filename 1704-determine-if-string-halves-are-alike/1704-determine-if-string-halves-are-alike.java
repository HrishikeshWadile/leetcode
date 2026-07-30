class Solution {
    public boolean halvesAreAlike(String s) {
        int vC = 0, h = s.length() / 2;
        for (int i = 0; i < h; i++) {
            if (isVowel(s.charAt(i))) vC++;
            if (isVowel(s.charAt(h + i))) vC--;
        }
        return vC == 0;
    }

    boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') return true;
        return false;
    }
}