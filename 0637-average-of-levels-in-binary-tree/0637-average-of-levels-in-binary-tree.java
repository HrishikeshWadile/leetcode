class Solution {
    List<Double> sum;
    List<Integer> count;

    public List<Double> averageOfLevels(TreeNode root) {
        sum = new ArrayList<>();
        count = new ArrayList<>();

        traverse(root, 0);

        for (int i = 0; i < sum.size(); i++) {
            sum.set(i, sum.get(i) / count.get(i));
        }

        return sum;
    }

    void traverse(TreeNode node, int d) {
        if (node == null) {
            return;
        }

        if (sum.size() == d) {
            sum.add((double) node.val);
            count.add(1);
        } else {
            sum.set(d, sum.get(d) + node.val);
            count.set(d, count.get(d) + 1);
        }

        traverse(node.left, d + 1);
        traverse(node.right, d + 1);
    }
}