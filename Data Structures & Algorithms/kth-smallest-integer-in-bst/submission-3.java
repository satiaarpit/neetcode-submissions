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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int currentIndex = 0;
        TreeNode current = root;
        while(current != null || !stack.isEmpty())  {
            while(current!= null)    {
                stack.push(current);
                current=current.left;
            }
            if(!stack.isEmpty())    {
                current = stack.pop();
                currentIndex++;
                if(currentIndex == k)   {
                    return current.val;
                }
                current = current.right;
            }
        }
        return -1;
    }
}
