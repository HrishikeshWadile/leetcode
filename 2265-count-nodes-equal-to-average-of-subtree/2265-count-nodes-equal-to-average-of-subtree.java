class Solution {
    int nC = 0;

    public int averageOfSubtree(TreeNode root) {
        traverse(root);
        return nC;
    }

    int[] traverse(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = traverse(node.left);
        int[] right = traverse(node.right);

        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;

        if (sum / count == node.val) {
            nC++;
        }

        return new int[]{sum, count};
    }
}