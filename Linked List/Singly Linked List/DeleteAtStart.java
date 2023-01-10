public class DeleteAtStart {
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

        node.printLinkedList(node.deleteAtStart(node)); //3->6->9->12->15->
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

    /*
    1. Check if the linked list is empty. If it is, there is nothing to delete and you can return.
    2. Set the head of the linked list to point to the second node in the list.
     */
    public ListNode deleteAtStart(ListNode head){
        if(head==null){
            tail=null;
        }
        head=head.next;
        return head; //garbage collector will take care of the previous un-accessible head
    } //TC: O(1)
}
