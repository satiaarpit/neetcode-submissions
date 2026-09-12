/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(0,lists.length-1,lists);
    }

    public ListNode merge(int i, int j, ListNode[] lists)   {
        if(i> j)    {
            return null;
        }
        if(i==j) {
            return lists[i];
        } else  {
            int mid = i + (j-i+1)/2;
            ListNode left = merge(i,mid-1,lists);
            ListNode right = merge (mid,j,lists);
            ListNode result = null;
            ListNode prev = null;
            while(left!=null && right!=null)    {
                ListNode node = new ListNode();
                if(left.val<right.val)  {
                    node.val=left.val;
                    left=left.next;
                } else  {
                    node.val=right.val;
                    right=right.next;
                }
                if(result == null)  {
                    result = node;
                }
                if(prev!=null)  {
                    prev.next = node;
                }
                prev = node;
            }
            while(left!=null)    {
                ListNode node = new ListNode();
                node.val=left.val;
                left=left.next;
                if(result == null)  {
                    result = node;
                }
                if(prev!=null)  {
                    prev.next = node;
                }
                prev = node;
            }
            while(right!=null)    {
                ListNode node = new ListNode();
                node.val=right.val;
                right=right.next;
                if(result == null)  {
                    result = node;
                }
                if(prev!=null)  {
                    prev.next = node;
                }
                prev = node;
            }
            return result;
        }
    }
}
