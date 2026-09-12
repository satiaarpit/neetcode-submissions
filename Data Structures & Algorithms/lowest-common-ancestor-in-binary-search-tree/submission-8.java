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
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        hasAnyDescendant(root, p, q);
        return result;
    }

    public boolean hasAnyDescendant(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)    {
            return false;
        }
        boolean isLeftDescendant = hasAnyDescendant(root.left, p, q);
        boolean isRightDescendant = hasAnyDescendant(root.right, p, q);
        //Its an ancestor if left and right has descendat or left has descendat and node has currenVal or right has descendat and node has currentVal
        boolean isAncestor = (isLeftDescendant && isRightDescendant) ||
                             ((root.val == p.val || root.val == q.val) && (isLeftDescendant || isRightDescendant));

        if(isAncestor && result == null) {
            result = root;
        }
        return isLeftDescendant || isRightDescendant || root.val == p.val || root.val == q.val;
    }
}
