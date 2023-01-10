public class DeleteDuplicatesFromSortedList{
    public static void main(String[] args) {
        System.out.println();
        ListNode node = new ListNode();
        node.val=3;
        node.next= new ListNode(6);
        node.next.next= new ListNode(9);
        node.next.next.next= new ListNode(9);
        node.next.next.next.next= new ListNode(12);

        node.printLinkedList(node); //3->6->9->9->12->
        System.out.println();

        node.printLinkedList(node.deleteDuplicatesFromSortedList(node)); //3->6->9->12->

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
    
    public ListNode deleteDuplicatesFromSortedList(ListNode head){
        if (head.next==null){
            return head;
        }
        ListNode current=head;
        while(current!=null){
            while (current.next!=null && current.val==current.next.val){
                current.next=current.next.next;
            }
            current=current.next;
        }
        return head;
    }
}
