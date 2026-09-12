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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = null;
        ListNode prev = null;
        while(l1 != null || l2!=null || carry != 0)   {
            if(l1!=null)    {
                carry+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null)    {
                carry+=l2.val;
                l2 = l2.next;
            }
            ListNode currentNode = new ListNode();
            currentNode.val = carry%10;
            carry = carry/10;
            if(result == null)  {
                result = currentNode;
            }
            if(prev!= null) {
                prev.next = currentNode;
            }
            prev = currentNode;
        }
        return result;
    }
}
