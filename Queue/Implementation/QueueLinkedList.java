public class QueueLinkedList {
    static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node front;
    private Node rear;

    public boolean isEmpty(){
        return front==null;
    }

    public void enqueue(int val){
        Node newNode = new Node(val);
        if(isEmpty()){
            front = rear = newNode;
        }
        else{
            rear.next=newNode;
            rear=newNode;
        }
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        int val = front.data;
        front=front.next;
        if(front==null){
            rear=null;
        }
        return val;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }
        return front.data;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }
        Node current=front;
        while(current!=null){
            System.out.print(current.data + " ");
            current=current.next;
        }
        System.out.println();
    }

}
