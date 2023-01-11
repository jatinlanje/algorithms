public class InsertAtEnd {
    public static void main(String[] args) {
        System.out.println();
        ListNode node = new ListNode(15);
        node=node.insertAtStart(node,12);
        node=node.insertAtStart(node,9);
        node=node.insertAtStart(node,6);
        node=node.insertAtStart(node,3); //3->6->9->12->15->

        node=node.insertAtEnd(node,18); //3->6->9->12->15->18->

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

    public ListNode insertAtEnd(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head==null) {
            head=newNode;
            return head;
        }
        ListNode last=head;
        while (last.next!=null) {
            last=last.next;
        }
        last.next=newNode;
        newNode.prev=last;
        return head;
    }

}
