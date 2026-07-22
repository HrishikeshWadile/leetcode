import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> used = new HashSet<>();

        int st = 0, e = 0;

        for (int i = 0; i < pattern.length(); i++) {

            // Not enough words
            if (st >= s.length()) return false;

            // Find end of current word
            while (e < s.length() && s.charAt(e) != ' ') {
                e++;
            }

            String word = s.substring(st, e);
            char ch = pattern.charAt(i);

            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(word))
                    return false;
            } else {
                if (used.contains(word))
                    return false;

                map.put(ch, word);
                used.add(word);
            }

            // Move to next word
            st = e + 1;
            e = st;
        }

        // Extra words remaining
        return st > s.length();
    }
}