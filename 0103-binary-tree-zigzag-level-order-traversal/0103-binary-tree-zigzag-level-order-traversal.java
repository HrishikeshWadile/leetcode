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
    List<List<Integer>> r;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        r = new ArrayList<>();
        traverse(root, 0);
        return r;
    }

    void traverse(TreeNode node, int depth) {
        if (node == null) return;
        if (depth == r.size()) {
            r.add(new ArrayList<>());
        }

        if (depth % 2 == 0) r.get(depth).add(node.val);
        else r.get(depth).add(0, node.val);

        traverse(node.left, depth + 1);
        traverse(node.right, depth + 1);
    }
}