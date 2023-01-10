public class InsertAtStart {
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

//        ListNode temp = node.insertAtStart(node,1);
//        node.printLinkedList(temp);
        node.printLinkedList(node.insertAtStart(node,1)); //1->3->6->9->12->15->

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
    2. Set the next field of the new node to point to the current head of the linked list.
    3. Set the head of the linked list to the new node.
     */
    public ListNode insertAtStart(ListNode head,int val){
        ListNode newNode = new ListNode(val); //create a new node
        newNode.next=head; //pointing new node to current head
        head=newNode; //now newNode is our new head
        if(tail==null){
            tail=head;
        }
        return head; //otherwise scope will end here only
    } //TC: O(1)
}
