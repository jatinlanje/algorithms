public class DeleteAtEnd {
    public static void main(String[] args) {
        System.out.println();
        ListNode node = new ListNode();
        node.val=3;
        node.next= new ListNode(6);
        node.next.next= new ListNode(9);
        node.next.next.next= new ListNode(12);
        node.next.next.next.next= new ListNode(15);

        node.printLinkedList(node); //3->6->9->12->15->
        System.out.println();

        node.printLinkedList(node.deleteAtEnd(node)); //3->6->9->12->

    }
}

class ListNode{ //self-referential class
    int val; //stores the element
    ListNode next; //stores the reference to the next node in the list by default null
    ListNode tail;

    ListNode(){ //default constructor

    }
    ListNode(int val){ //parameterised constructor
        this.val = val;
        this.next=null; //optional in java but standard practice is to write this.next=null;
    }

    public void printLinkedList(ListNode head){
        ListNode current=head;
        while(current!=null){
            System.out.print(current.val+"->");
            current=current.next;
        }
        //System.out.println("NULL");
    }

    public ListNode deleteAtStart(ListNode head){
        if(head==null){
            tail=null;
        }
        head=head.next;
        return head; //garbage collector will take care of the previous un-accessible head
    } //TC: O(1)

    /*
    1. Check if the linked list is empty. If it is, return null.
    2. Check if the linked list has only one node. If it does, set the head of the linked list to null and return.
    3. Traverse the linked list until you reach the second-to-last node.
    4. Set the next field of the second-to-last node to null. This will remove the last node from the list.
     */

    public ListNode deleteAtEnd(ListNode head){
        if (head == null) {
            return null;
        }
        if (head == tail) { //if the list has only one node, we need to update both head and tail
            deleteAtStart(head);
        }
        ListNode secondLastNode=head;
        while(secondLastNode.next.next!=null){ //Traverse the linked list until you reach the second-to-last node.
            secondLastNode=secondLastNode.next;
        }
        secondLastNode.next = null; //garbage collector will take care of previous un-accessible tail
        tail=secondLastNode;
        return head;
    } //TC: O(N)
}
