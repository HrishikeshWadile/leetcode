class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'a';
            int b = t.charAt(i) - 'a';

            freq[a]++;
            freq[b]--;
        }

        for (int num : freq) {
            if (num != 0) return false;
        }

        return true;
    }
}