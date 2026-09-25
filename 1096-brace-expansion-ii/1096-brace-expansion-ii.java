class Solution {
    public List<String> braceExpansionII(String expression) {

        Deque<Set<String>> stack = new ArrayDeque<>();
        Deque<Set<String>> unionStack = new ArrayDeque<>();

        Set<String> curr = new HashSet<>();
        curr.add("");

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // Start a new brace level
            if (ch == '{') {

                stack.push(curr);

                // Everything inside this {} initially
                // belongs to an empty union.
                unionStack.push(new HashSet<>());

                curr = new HashSet<>();
                curr.add("");
            }

            // Current alternative is finished
            else if (ch == ',') {

                unionStack.peek().addAll(curr);

                // Start next alternative
                curr = new HashSet<>();
                curr.add("");
            }

            // Finish current brace
            else if (ch == '}') {

                // Add the final alternative
                unionStack.peek().addAll(curr);

                // Complete union inside {}
                Set<String> inside = unionStack.pop();

                // Expression before {
                Set<String> before = stack.pop();

                // Concatenate before × inside
                curr = concatenate(before, inside);
            }

            // Letter
            else {

                Set<String> next = new HashSet<>();

                for (String s : curr) {
                    next.add(s + ch);
                }

                curr = next;
            }
        }

        List<String> result = new ArrayList<>(curr);
        Collections.sort(result);

        return result;
    }

    private Set<String> concatenate(Set<String> a, Set<String> b) {

        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}