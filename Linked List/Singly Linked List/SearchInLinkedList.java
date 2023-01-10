public class SearchInLinkedList {
    public static void main(String[] args) {
        System.out.println();
        ListNode node = new ListNode();
        node.val=3;
        node.next= new ListNode(6);
        node.next.next= new ListNode(9);

        node.printLinkedList(node); //3->6->9->
        System.out.println();
        System.out.println(node.searchInLinkedList(node,1)); //false

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

    public boolean searchInLinkedList(ListNode head, int k){
        ListNode current=head;
        while(current!=null){
            if(current.val==k){
                return true;
            }
            current=current.next;
        }
        return false;
    }
}
