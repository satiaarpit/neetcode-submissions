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

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumDFS(root);
        return max;
    }

    public int maxPathSumDFS(TreeNode root) {
        if(root == null)    {
            return 0;
        }
        int leftMax = maxPathSumDFS(root.left);
        int rightMax = maxPathSumDFS(root.right);
        //Set maxs
        //First only leftSumTree;
        int leftOrRightMaxSum = (leftMax > rightMax ? leftMax : rightMax) + root.val;
        if(root.val > max)  {
            max = root.val;    
        }
        if(leftOrRightMaxSum > max) {
            max = leftOrRightMaxSum;
        }
        int totalTreeSum = leftMax + rightMax + root.val;
        if(totalTreeSum > max)  {
            max = totalTreeSum;
        }
        return root.val > leftOrRightMaxSum ? root.val : leftOrRightMaxSum;
    }
}
