public class ReverseLinkedList {
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

        node.printLinkedList(node.reverseLinkedList(node)); //3->6->9->12->15

    }
}

// nested class to define linked list node
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
    Iterative approach, which involves updating the next pointers of the nodes in the list to point to the previous node.
     */

    public ListNode reverseLinkedList(ListNode head){
        ListNode h1=head;
        ListNode h2=null;
        ListNode temp=head;
        while(h1!=null){
            temp=h1; //head
            h1=h1.next; //to preserve remaining linked list
            temp.next=h2; //link is broken and now pointing to h2
            h2=temp; //last node added
        }
        return h2;
    }
}
