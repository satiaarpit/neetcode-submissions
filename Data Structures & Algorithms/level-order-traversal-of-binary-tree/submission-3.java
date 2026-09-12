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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)    {
            return list;
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> currentDeptResult = new ArrayList<>();
            while(currentSize > 0)  {
                TreeNode node = queue.remove();
                currentDeptResult.add(node.val);
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
                currentSize--;
            }
            list.add(currentDeptResult);
        }
        return list;
    }
}
