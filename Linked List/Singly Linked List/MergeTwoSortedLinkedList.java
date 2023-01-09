public class MergeTwoSortedLinkedList{
    public static void main(String[] args) {
        System.out.println();
        ListNode l1 = new ListNode();
        l1.val=3;
        l1.next= new ListNode(6);
        l1.next.next= new ListNode(9);
        l1.next.next.next= new ListNode(12);
        l1.next.next.next.next= new ListNode(15);

        l1.printLinkedList(l1); //3->6->9->12->15->
        System.out.println();

        ListNode l2 = new ListNode();
        l2.val=2;
        l2.next= new ListNode(4);
        l2.next.next= new ListNode(6);
        l2.next.next.next= new ListNode(8);
        l2.next.next.next.next= new ListNode(10);

        l2.printLinkedList(l2); //2->4->6->8->10->
        System.out.println();

        l1.printLinkedList(l1.mergeTwoSortedLinkedList(l1,l2)); //2->3->4->6->6->8->9->10->12->15

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
    1. If one of the lists is empty, return the other list.
    2. Compare the values at the heads of the two input lists and add the smaller value to the merged list.
     */

    public ListNode mergeTwoSortedLinkedList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoSortedLinkedList(list1.next, list2);
            return list1;
        }
        else {
            list2.next = mergeTwoSortedLinkedList(list1, list2.next);
            return list2;
        }
    }
}
