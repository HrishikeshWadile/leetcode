class Solution {
    public List<String> partitionString(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            String current = s.substring(start, end + 1);

            if (!set.contains(current)) {
                set.add(current);
                result.add(current);
                start = end + 1;
            }
        }

        return result;
    }
}