public class DeleteKthNodeFromEnd {
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

        node.printLinkedList(node.removeKthNodeFromEnd(node,2)); //3->6->9->15->

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

    public int findLength(ListNode head){
        int length=0;
        ListNode current=head;
        while(current!=null){
            current=current.next;
            length++;
        }
        return length;
    }

    /*
    can be done using two pointer also!
     */

    public ListNode deleteKthNodeFromEnd(ListNode head, int k){
        if(findLength(head)==0 || findLength(head)==1){
            return null;
        }
        if(findLength(head)==k){
            return head.next=head.next;
        }
        if(k<findLength(head)){
            int n=findLength(head)-k;
            ListNode current=head;
            int count=0;
            while(count<n-1){
                current=current.next;
                count++;
            }
            current.next=current.next.next;
        }
        return head;
    }

}
