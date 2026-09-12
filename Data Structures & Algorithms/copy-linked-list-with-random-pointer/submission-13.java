/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node result = null;
        Map<Node,Node> map = new HashMap();
        Node current = head;
        Node prev = null;
        //Node dummyResult = new Node();
        //Node result = dummyResult;
        while(current != null)  {
            Node n;
            if(map.containsKey(current)) {
                n = map.get(current);
            } else  {
                n = new Node(current.val);
                map.put(current, n);
            }
            if(prev != null)    {
                prev.next = n;
            }
            if(map.containsKey(current.random))    {
                n.random = map.get(current.random);
            } else  {
                if(current.random == null)  {
                    n.random = null;
                } else  {
                    Node random = new Node(current.random.val);
                n.random = random;
                map.put(current.random, random);
                }
            }
            prev = n;
            if(result == null)  {
                result = n;
            }
            current = current.next;
        }
        return result;
    }
}
