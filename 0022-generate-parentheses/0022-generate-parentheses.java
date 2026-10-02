class Solution {
    private List<String> result;
    private int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        result = new ArrayList<>();

        char[] curr = new char[2 * n];
        createAndDFS(curr, 0, 0, 0);

        return result;
    }

    private void createAndDFS(char[] curr, int idx, int open, int close) {
        if (open == n && close == n) {
            result.add(new String(curr));
            return;
        }

        if (open < n) {
            curr[idx] = '(';
            createAndDFS(curr, idx + 1, open + 1, close);
        }

        if (close < open) {
            curr[idx] = ')';
            createAndDFS(curr, idx + 1, open, close + 1);
        }
    }
}