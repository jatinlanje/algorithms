public class PartitionList {
    public static void main(String[] args) {
        System.out.println();
        ListNode node = new ListNode();
        node.val=1;
        node.next= new ListNode(4);
        node.next.next= new ListNode(3);
        node.next.next.next= new ListNode(2);
        node.next.next.next.next= new ListNode(5);
        node.next.next.next.next.next= new ListNode(2);


        node.printLinkedList(node); //1->4->3->2->5->2
        System.out.println();

        node.printLinkedList(node.partitionList(node,3)); //1->2->2->4->3->5->

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
    1. Create two dummy Linked List
    2. small -> if value is less than target
    3. higher -> if val is greater/equal to target
    4. and merge them
     */

    public ListNode partitionList(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode higher = new ListNode(0);

        ListNode smallHead=small;
        ListNode higherHead = higher;

        while(head!=null){
            if(head.val<x){
                //small list
                smallHead.next = head;
                smallHead = smallHead.next;
            }
            else{
                //high list
                higherHead.next = head;
                higherHead = higherHead.next;
            }
            head=head.next;
        }
        higherHead.next = null;
        smallHead.next = higher.next;
        return small.next;
    }

}
