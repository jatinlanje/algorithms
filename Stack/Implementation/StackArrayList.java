import java.util.ArrayList;

public class StackArrayList<T> {
    public static void main(String[] args) {
        StackArrayList<Integer> myStack = new StackArrayList<Integer>();
        myStack.push(1); // pushes the value 1 onto the stack
        myStack.push(2); // pushes the value 2 onto the stack
        myStack.push(3); // pushes the value 3 onto the stack

        myStack.display(); // displays the contents of the stack: 3 2 1

        // Pop an element off the stack
        int poppedValue = myStack.pop(); // removes and returns the value at the top of the stack (3)
        System.out.println("Popped value: " + poppedValue); // prints "Popped value: 3"

        myStack.display(); // displays the contents of the stack: 2 1

    }

    private ArrayList<T> list; // underlying data structure
    private int top; // index of the top element

    // constructor
    public StackArrayList() {
        this.list = new ArrayList<>();
        this.top = -1; // initialize top to -1 for an empty stack
    }

    // push method
    public void push(T item) {
        // add the item at the top index and increment top
        list.add(++top, item);
    }

    // pop method
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        // remove the item at the top index and decrement top
        return list.remove(top--);
    }

    // check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
