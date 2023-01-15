public class StackLinkedList {
    public static void main(String[] args) {
        StackLinkedList myStack = new StackLinkedList(); // creates a stack
        myStack.push(1); // pushes the value 1 onto the stack
        myStack.push(2); // pushes the value 2 onto the stack
        myStack.push(3); // pushes the value 3 onto the stack

        myStack.display(); // displays the contents of the stack: 3 2 1

        int poppedValue = myStack.pop(); // removes and returns the value at the top of the stack (3)
        System.out.println("Popped value: " + poppedValue); // prints "Popped value: 3"

        myStack.display(); // displays the contents of the stack: 2 1
    }
    private Node top;

    private class Node {
        int data;
        Node next;
    }

    // check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // push value into stack
    public void push(int value) {
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = top;
        top = newNode;
    }

    // pop value from stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            int value = top.data;
            top = top.next;
            return value;
        }
    }

    // display stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            Node current = top;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}
