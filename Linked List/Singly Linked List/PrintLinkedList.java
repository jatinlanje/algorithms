public class PrintLinkedList {
    public static void main(String[] args) {
        System.out.println();
        ListNode node = new ListNode(); //head is reference variable of object, so we need to create object of type ListNode using new
        System.out.println(node); //address/memory location
        System.out.println(node.val); //0
        node.val=3;
        System.out.println(node.val); //3
        System.out.println();

        System.out.println(node.next); //pointing to null
        //System.out.println(ListNode.next.val); //NullPointerException because ListNode.next is null
        node.next= new ListNode(6); //head.next is reference variable of object, so we need to create object of type ListNode using new
        System.out.println(node.next); //address/memory location
        System.out.println(node.next.val); //6
        System.out.println();

        System.out.println(node.next.next); //pointing to null
        //System.out.println(ListNode.next.next.val); //NullPointerException because ListNode.next.next is null
        node.next.next= new ListNode(9); //head.next is reference variable of object, so we need to create object of type ListNode using new
        System.out.println(node.next.next); //address/memory location
        System.out.println(node.next.next.val); //9
        System.out.println();
        
        node.printLinkedList(node); //3->6->9->
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
}
