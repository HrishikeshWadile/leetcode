class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> r = new ArrayList<>();
        String[] words = text.split(" ");
        int n = words.length;
        for (int i = 0; i < n - 2; i++) {
            if (words[i].equals(first)) {
                if (words[i + 1].equals(second)) {
                    r.add(words[i + 2]);
                }
            }
        }

        return r.toArray(new String[0]);
    }
}