public class StackArray {
    public static void main(String[] args) {
        StackArray myStack = new StackArray(5); // creates a stack with a size of 5
        myStack.push(1); // pushes the value 1 onto the stack
        myStack.push(2); // pushes the value 2 onto the stack
        myStack.push(3); // pushes the value 3 onto the stack

        myStack.display(); // displays the contents of the stack: 3 2 1

        int poppedValue = myStack.pop(); // removes and returns the value at the top of the stack (3)
        System.out.println("Popped value: " + poppedValue); // prints "Popped value: 3"

        myStack.display(); // displays the contents of the stack: 2 1

        if(myStack.push(6) == false){
            System.out.println("Push operation failed");
        }
    }

    private int top;
    private int[] stack;
    private int size;

    // constructor
    public StackArray(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    // check if stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // check if stack is full
    public boolean isFull() {
        return (top == size - 1);
    }

    // push value into stack
    public boolean push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            top++;
            stack[top] = value;
            return true;
        }
    }

    // pop value from stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int value = stack[top];
            top--;
            return value;
        }
    }

    // display stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}
