public class MergeSortLinkedList {
    public static void main(String[] args) {
        System.out.println();
        ListNode node = new ListNode();
        node.val=12;
        node.next= new ListNode(15);
        node.next.next= new ListNode(3);
        node.next.next.next= new ListNode(9);
        node.next.next.next.next= new ListNode(6);

        node.printLinkedList(node); //12->15->3->9->6->
        System.out.println();

        node.printLinkedList(node.mergeSortLinkedList(node)); //3->6->9->12->15

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

    public ListNode getMid(ListNode head){ //for mid-1 even length
        ListNode slow=head; //slow pointer jumps 1 at a time
        ListNode fast=head; //fast pointer jumps 2 at a time
        //so basically when fast pointer reaches the end, slow will be in the middle
        while(fast!=null && fast.next!=null && fast.next.next != null){
            /*
            && fast.next.next != null
            for mid-1 even length
             */
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    /*
    The basic idea is to divide the list into two halves, sort each half, and then merge the two sorted halves back together.
     */

    public ListNode mergeSortLinkedList(ListNode head) {
        if(head==null || head.next==null){ //head.next==null means only 1 node
            return head;
        }
        ListNode mid=getMid(head);
        ListNode h2=mid.next;
        mid.next=null;

        ListNode h1=head;
        h1=mergeSortLinkedList(h1);
        h2=mergeSortLinkedList(h2);
        return mergeTwoSortedLinkedList(h1,h2);
    }
}
//TC: O(NLogN)
//SC: O(LogN) recursive call stack
