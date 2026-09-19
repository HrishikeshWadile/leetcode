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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null || root.left == null) return root;
        traverse(root.left, root.right, true);
        return root;
    }

    void traverse (TreeNode l, TreeNode r, boolean d) {
        if (l == null) return;
        if (d) {
            int temp = l.val;
            l.val = r.val;
            r.val = temp;
        }
        traverse(l.left, r.right, !d);
        traverse(l.right, r.left, !d);
    }
}