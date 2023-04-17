public class ReverseInKGroups {
    public static void main(String[] args) {
        System.out.println();
        ListNode node = new ListNode();
        node.val=3;
        node.next= new ListNode(6);
        node.next.next= new ListNode(9);
        node.next.next.next= new ListNode(12);
        node.next.next.next.next= new ListNode(15);
        node.next.next.next.next.next= new ListNode(18);
        node.next.next.next.next.next.next= new ListNode(21);
        node.next.next.next.next.next.next.next= new ListNode(24);
        node.next.next.next.next.next.next.next.next= new ListNode(27);

        node.printLinkedList(node); //3->6->9->12->15->18->21->24->27
        System.out.println();

        node.printLinkedList(node.reverseInKGroups(node,3)); //9->6->3->18->15->12->27->24->21->

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
    Similar to reverse first K nodes 
     */

    public ListNode reverseInKGroups(ListNode head, int k){
        /*Assumption
        reverseInKGroups will reverse all groups of size k in Linked List starting from 'node' and return the updated head
         */
        if(k<=1 || head==null){
            return head;
        }
        ListNode h1=head;
        ListNode h2=null;
        ListNode temp=head;
        int count=k;
        while(h1!=null && count>0){
            temp=h1; //head
            h1=h1.next; //to preserve remaining linked list
            temp.next=h2; //link is broken and now pointing to h2
            h2=temp; //last node added
            count--;
        }
        head.next=reverseInKGroups(h1,k);
        return h2;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) {
            return head;
        }

        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode = null;
        int count = 0;

        // Count the number of nodes in the list
        while (currNode != null && count < k) {
            count++;
            currNode = currNode.next;
        }

        // Check if there are enough nodes to form a group of k nodes
        if (count < k) {
            return head;
        }

        currNode = head;
        count = 0;

        // Reverse k nodes in a group
        while (currNode != null && count < k) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            count++;
        }

        // Recursively reverse the next k nodes
        if (nextNode != null) {
            head.next = reverseKGroup(nextNode, k);
        }

        return prevNode;
    }

}
