class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();

        // key -> value
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder sb = new StringBuilder();

        int l = 0;
        int i = 0;
        int n = s.length();

        while (i < n) {

            // Find next '('
            while (i < n && s.charAt(i) != '(') {
                i++;
            }

            // Append normal text before '('
            sb.append(s.substring(l, i));

            // No more brackets
            if (i == n) {
                break;
            }

            // Find ')'
            int j = i + 1;
            while (j < n && s.charAt(j) != ')') {
                j++;
            }

            // Extract key
            String key = s.substring(i + 1, j);

            // Replace key, or '?' if not present
            sb.append(map.getOrDefault(key, "?"));

            // Continue after ')'
            l = j + 1;
            i = l;
        }

        return sb.toString();
    }
}