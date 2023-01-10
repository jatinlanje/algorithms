public class MiddleElement {
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

        System.out.println(node.middleElementOfLinkedList(node)); //9
    }
}

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

    public int middleElement(ListNode head){ //for mid-1 even length
        ListNode slow=head; //slow pointer jumps 1 at a time
        ListNode fast=head; //fast pointer jumps 2 at a time
        //so basically when fast pointer reaches the end, slow will be in the middle
        while(fast!=null && fast.next!=null){
            /*
            && fast.next.next != null
            for mid-1 even length
             */
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.val;
    }
}
