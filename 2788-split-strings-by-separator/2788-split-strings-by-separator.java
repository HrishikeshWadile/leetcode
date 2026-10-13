class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> r = new ArrayList<>();
        int n = words.size(), ls = 0, l;
        String s;
        for (int i = 0; i < n; i++) {
            s = words.get(i);
            l = s.length();
            ls = 0;

            for (int j = 0; j < l; j++) {
                if (s.charAt(j) == separator) {
                    if (ls < j) r.add(s.substring(ls, j));
                    ls = j + 1;
                }
            }

            if (ls < l) r.add(s.substring(ls));
        }
        return r;
    }
}
