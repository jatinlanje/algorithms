public class CompareLinkedList {
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
        l2.val=3;
        l2.next= new ListNode(6);
        l2.next.next= new ListNode(9);
        l2.next.next.next= new ListNode(12);
        l2.next.next.next.next= new ListNode(15);

        l2.printLinkedList(l2); //3->6->9->12->15->
        System.out.println();

        System.out.println(l1.compareLinkedList(l1,l2)); //true
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

    public boolean compareLinkedList(ListNode list1, ListNode list2){
        ListNode current1=list1;
        ListNode current2=list2;
        while(current1!=null && current2!=null){
            if(current1.val!=current2.val){
                return false;
            }
            current1=current1.next;
            current2=current2.next;
        }
        return true;
    }
}
