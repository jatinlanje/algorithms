public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println();
        ListNode node = new ListNode();
        node.val=3;
        node.next= new ListNode(6);
        node.next.next= new ListNode(9);
        node.next.next.next= new ListNode(6);
        node.next.next.next.next= new ListNode(3);


        node.printLinkedList(node); //3->6->9->6->3->
        System.out.println();

        boolean result = node.isPalindrome(node); //true
        System.out.println(result);

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

    public ListNode findMiddle(ListNode head){ //for mid-1 even length
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
        return slow;
    }

    public ListNode reverseLinkedList(ListNode head){
        ListNode h1=head;
        ListNode h2=null;
        ListNode temp=head;
        while(h1!=null){
            temp=h1; //head
            h1=h1.next; //to preserve remaining linked list
            temp.next=h2; //link is broken and now pointing to h2
            h2=temp; //last node added
        }
        return h2;
    }

    /*
    1. break Linked List int two halves
    2. reverse second half
    3. compare both halves
     */

    public boolean isPalindrome(ListNode head){
        if(head==null || head.next==null){
            return true;
        }
        ListNode middle=findMiddle(head);
        ListNode secondHalf=reverseLinkedList(middle);
        while(secondHalf!=null){
            if(head.val!=secondHalf.val){
                return false;
            }
            head=head.next;
            secondHalf=secondHalf.next;
        }
        return true;
    }

}
