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

    ArrayList<Integer> list = new ArrayList<>(); // underlying data structure

    // check if stack is empty
    public boolean isEmpty() {
        return list.size() == 0;
    }

    // push method
    public void push(int data) {
        // add the item at the end
        list.add(data);
    }

    // pop method
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        // remove the item at the end
        int top=list.get(list.size()-1);
        list.remove(list.size()-1);
        return top;
    }

    // peek method
    public int peek(){
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return list.get(list.size()-1);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            for (int i = list.size()-1; i >= 0; i--) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}

