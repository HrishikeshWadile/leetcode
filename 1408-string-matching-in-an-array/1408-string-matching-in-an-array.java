class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length())
                return a.length() - b.length();
            return a.compareTo(b);
        });
        List<String> r = new ArrayList<>();
        int i = 0, j = 0;
        while (i < words.length - 1) {
            j = i + 1;
            while (j < words.length) {
                if (words[j].contains(words[i])) {
                    r.add(words[i]);
                    break;
                }
                j++;
            }
            i++;
        }
        return r;
    }
}