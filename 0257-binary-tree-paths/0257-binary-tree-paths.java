/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<String> r;

    public List<String> binaryTreePaths(TreeNode root) {
        r = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        dfs(root, sb);

        return r;
    }

    void dfs(TreeNode node, StringBuilder sb) {
        int length = sb.length();

        sb.append(node.val);

        if (node.left == null && node.right == null) {
            r.add(sb.toString());
            sb.setLength(length);
            return;
        }

        sb.append("->");

        if (node.left != null) {
            dfs(node.left, sb);
        }

        if (node.right != null) {
            dfs(node.right, sb);
        }

        sb.setLength(length);
    }
}