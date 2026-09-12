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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    public int goodNodes(TreeNode root, int maxVal) {
        if(root == null)    {
            return 0;
        }

        int leftCount = goodNodes(root.left, root.val > maxVal ? root.val : maxVal);
        int rightCount = goodNodes(root.right, root.val > maxVal ? root.val : maxVal);
        return leftCount + rightCount + (root.val >= maxVal ? 1 : 0);
    }
}
