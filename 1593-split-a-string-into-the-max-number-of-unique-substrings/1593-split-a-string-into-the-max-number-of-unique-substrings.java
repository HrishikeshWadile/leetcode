class Solution {
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        return backtrack(s, 0, set);
    }

    private int backtrack(String s, int index, HashSet<String> set) {
        if (index == s.length()) {
            return set.size();
        }

        int max = 0;

        for (int end = index + 1; end <= s.length(); end++) {
            String part = s.substring(index, end);

            if (!set.contains(part)) {
                set.add(part);

                max = Math.max(max, backtrack(s, end, set));

                set.remove(part);
            }
        }

        return max;
    }
}