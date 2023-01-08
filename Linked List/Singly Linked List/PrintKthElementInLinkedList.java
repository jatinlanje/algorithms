public class PrintKthElementInLinkedList {
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

        System.out.println(node.printKthElementInLinkedList(node,2)); //9
    }
}

// nested class to define linked list node
class ListNode{ //self-referential class
    int val; //stores the element
    ListNode next; //stores the reference to the next node in the list by default null

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

    public int printKthElementInLinkedList(ListNode head, int k){ //0 based indexing
        int count=0;
        ListNode current=head;
        while(current!=null){
            if(count==k){ //k-1 for 1 based indexing
                return current.val;
            }
            current=current.next;
            count++;
        }
        return 0;
    }
}
