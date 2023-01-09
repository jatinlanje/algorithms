public class InsetAtKthPosition {
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

        node.printLinkedList(node.insetAtKthPosition(node,1,2)); //3->6->1->9->12->15

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

    public ListNode insertAtStart(ListNode head,int val){
        ListNode newNode = new ListNode(val); //create a new node
        newNode.next=head; //pointing new node to current head
        head=newNode; //now newNode is our new head
        if(tail==null){
            tail=head;
        }
        return head; //otherwise scope will end here only
    } //TC: O(1)

    /*
    1. Create a new Node
    2. If k is 0, that means we want to insert the new node at the beginning of the list.
    3. Find the k-1 node
    4. Insert the new node after the k-1th node
     */

    public ListNode insetAtKthPosition(ListNode head,int val, int k){
        if (head==null) {
            return null;
        }
        if(k==0){
            insertAtStart(head,val);
        }
        ListNode newNode = new ListNode(val); //create a new node
        int count=0;
        ListNode current=head;
        while(count<k-1 && current.next!=null){ //to get k-1 node
            current=current.next;
            count++;
        }
        //inserting the new node after the k-1th node
        newNode.next=current.next; //set the next pointer of the new node to the next pointer of the current node.
        current.next=newNode; //set the next pointer of the current node to the new node.
        return head;
    } //TC: O(N)
}
