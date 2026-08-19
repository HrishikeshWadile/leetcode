class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        int[] depth = new int[2];
        TreeNode[] parent = new TreeNode[2];

        find(root, x, y, depth, parent, null, 1);

        return depth[0] == depth[1] && parent[0] != parent[1];
    }

    void find(TreeNode node, int x, int y,
              int[] depth, TreeNode[] parent,
              TreeNode par, int d) {

        if (node == null)
            return;

        if (node.val == x) {
            depth[0] = d;
            parent[0] = par;
        }

        if (node.val == y) {
            depth[1] = d;
            parent[1] = par;
        }

        find(node.left, x, y, depth, parent, node, d + 1);
        find(node.right, x, y, depth, parent, node, d + 1);
    }
}