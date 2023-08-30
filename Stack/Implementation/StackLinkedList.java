public class StackLinkedList {

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            next=null;
        }
    }

    public static Node head;

    public static boolean isEmpty(){
        return head==null;
    }

    public static void push(int val){
        Node newNode = new Node(val);
        if(isEmpty()){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    public static int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        int val= head.data;
        head = head.next;
        return val;
    }

    public static int peek(){
        if (isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return head.data;
    }

    public static void display(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
        }
        else{
            Node current=head;
            while(current!=null){
                System.out.print(current.data + " ");
                current=current.next;
            }
            System.out.println();
        }
    }
}
