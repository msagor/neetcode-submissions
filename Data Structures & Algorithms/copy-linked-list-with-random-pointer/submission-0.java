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
    //watched video then watched implementation then typed myself
    public Node copyRandomList(Node head) {
        //create a hashmap where we store old to new objects
        Map<Node, Node> oldToNewNodes = new HashMap<Node, Node>();

        //first pass is to just create the new nodes and store them in the map
        Node currNode = head;
        while(currNode!=null){
            //create new node with val only
            Node newNode = new Node(currNode.val);

            //store the new node
            oldToNewNodes.put(currNode, newNode);

            //increment currNode
            currNode = currNode.next;
        }

        //at this point, all nodes exists, but not linked
        //second pass is to join the next and random pointers from old to new
        //need to start from head again
        currNode = head;

        while(currNode!=null){
            //get the literal new node associated to this old node
            Node newNode = oldToNewNodes.get(currNode);

            //get the literal next node of the old node
            Node nextNode = oldToNewNodes.get(currNode.next);

            //assign newNode next to nextNode
            newNode.next = nextNode;

            //get the literal random node of the old node
            Node randNode = oldToNewNodes.get(currNode.random);

            //assign newNode random to randNode
            newNode.random = randNode;

            //increment currNode
            currNode = currNode.next;

        }

        return oldToNewNodes.get(head);
    }
}
