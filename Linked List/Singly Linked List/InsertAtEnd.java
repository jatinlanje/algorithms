public class InsertAtEnd {
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

        node.printLinkedList(node.insertAtEnd(node,1)); //3->6->9->12->15->1->

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
    1. Create a new node with the value that you want to insert.
    2. Check if the linked list is empty. If it is, set the head of the linked list to the new node.
    3. If the linked list is not empty, traverse the list until you reach the last node.
    4. Set the next field of the last node to the new node.
     */

    public ListNode insertAtEnd(ListNode head,int val){ //without tail
        ListNode newNode = new ListNode(val);
        if(head==null){
            head=newNode;
        }
        else{
            ListNode current=head;
            while(current.next!=null){
                current=current.next;
            }
            current.next=newNode;
        }
        return head;
    } //TC: O(N) because we are not maintaining tail reference
}
