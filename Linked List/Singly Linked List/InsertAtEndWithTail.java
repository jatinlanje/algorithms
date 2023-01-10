public class InsertAtEndWithTail {
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

        node.setTail(node);

        node.printLinkedList(node.insertAtEndWithTail(node,1)); //3->6->9->12->15->1->

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

    public ListNode insertAtStart(ListNode head,int val){
        ListNode newNode = new ListNode(val); //create a new node
        newNode.next=head; //pointing new node to current head
        head=newNode; //now newNode is our new head
        if(tail==null){
            tail=head;
        }
        return head; //otherwise scope will end here only
    } //TC: O(1)

    public void setTail(ListNode head){
        ListNode current=head;
        while(current!=null){
            tail=current;
            current=current.next;
        }
    }

    /*
    1. Create a new node with the value that you want to insert.
    2.Check if the linked list is empty. If it is, set the head and tail of the linked list to the new node.
    3.If the linked list is not empty, set the next field of the tail to the new node, and then update the tail to be the new node.
     */

    public ListNode insertAtEndWithTail(ListNode head,int val){
        if(tail==null){
            insertAtStart(head,val);
        }
        ListNode newNode = new ListNode(val); //create a new node
        tail.next=newNode; //earlier tail.next was null now it is pointing to newNode
        tail=newNode; //now newNode is our new tail
        return head;
    } //TC: O(1) because we are maintaining tail reference
}
