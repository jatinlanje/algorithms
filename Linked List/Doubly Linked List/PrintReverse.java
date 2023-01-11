public class PrintReverse {
    public static void main(String[] args) {
        System.out.println();
        ListNode node = new ListNode(15);
        node=node.insertAtStart(node,12);
        node=node.insertAtStart(node,9);
        node=node.insertAtStart(node,6);
        node=node.insertAtStart(node,3); //3->6->9->12->15->

        node.printLinkedList(node); //3->6->9->12->15->
        System.out.println();
        node.printReverse(node); //15->12->9->6->3->
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

    public void printReverse(ListNode head){
        ListNode current=head;
        ListNode last=null;
        while(current!=null){
            last=current;
            current=current.next;
        }
        while(last!=null){
            System.out.print(last.val+"->");
            last=last.prev;
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
