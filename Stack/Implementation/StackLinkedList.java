public class StackLinkedList {
    public static void main(String[] args) {
        StackLinkedList myStack = new StackLinkedList(); // creates a stack
        myStack.push(1); // pushes the value 1 onto the stack
        myStack.push(2); // pushes the value 2 onto the stack
        myStack.push(3); // pushes the value 3 onto the stack

        myStack.display(); // displays the contents of the stack: 3 2 1

//        while(!myStack.isEmpty()){ // display
//            System.out.print(myStack.peek()+" ");
//            myStack.pop();
//        }

        int poppedValue = myStack.pop(); // removes and returns the value at the top of the stack (3)
        System.out.println("Popped value: " + poppedValue); // prints "Popped value: 3"

        myStack.display(); // displays the contents of the stack: 2 1
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data=data;
            next=null;
        }
    }

    public static Node head;

    // check if stack is empty
    public static boolean isEmpty() {
        return head == null;
    }

    // push value into stack
    public static void push(int value) {
        Node newNode = new Node(value);
        if(isEmpty()){
            head=newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // pop value from stack
    public static int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            int top = head.data;
            head = head.next;
            return top;
        }
    }

    public static int peek(){
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return head.data;
        }
    }

    // display stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}
