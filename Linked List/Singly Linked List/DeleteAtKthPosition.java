public class DeleteAtKthPosition {
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

        node.printLinkedList(node.deleteAtKthPosition(node,2)); //3->6->12->15

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
    1. If k==0, Delete the head
    2. Find the k-1th node and
    3. Find the k-1 node and Delete the kth node
     */

    public ListNode deleteAtKthPosition(ListNode head, int k) {
        if(head==null) {
            return null;
        }
        ListNode current=head;
        if(k==0){
            head=head.next;
        }
        else{
            int count=0;
            while(count<k-1 && current.next!=null){ //to get k-1 node
                current=current.next;
                count++;
            }
            current.next=current.next.next; //deleting the kth node
        }
        return head;
    }//TC: O(N)
}
