public class InsertAtStart {
    public static void main(String[] args) {
        System.out.println();
        ListNode node = new ListNode(15);
        node=node.insertAtStart(node,12);
        node=node.insertAtStart(node,9);
        node=node.insertAtStart(node,6);
        node=node.insertAtStart(node,3); ////3->6->9->12->15->

        node.printLinkedList(node);
    }
}

class ListNode{ //self-referential class
    int val; //stores the element
    ListNode next; //stores the reference to the next node in the list by default null
    ListNode prev; //stores the reference to the prev node in the list by default null

    public ListNode() {

    }

    ListNode(int val){ //parameterised constructor
        this.val = val;
    }

    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public void printLinkedList(ListNode head){
        ListNode current=head;
        while(current!=null){
            System.out.print(current.val+"->");
            current=current.next;
        }
        //System.out.println("NULL");
    }
    
    /*
    1. Create a new node with the data you want to insert.
    2. Make the new node's next pointer point to the current head of the list.
    3. Make the new node's previous pointer point to null, since it is now the first node in the list.
    4. If the head of the list is not null (i.e., the list is not empty), make the current head's previous pointer point to the new node.
    5. Update the head of the list to be the new node.
     */

    public ListNode insertAtStart(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        newNode.prev = null;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        return head;
    }

}
