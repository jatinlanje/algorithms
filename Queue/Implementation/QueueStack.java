import java.util.Stack;

public class QueueStack {
    public static void main(String[] args) {
        QueueStack queue = new QueueStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
    
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int count;

    // Initialize both stacks
    public QueueStack() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        count = 0;
    }

    // Enqueue an item
    public void enqueue(int item) {
        if (count == 0) {
            stack1.push(item);
        } else {
            count--;
        }
    }

    // Dequeue an item
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
                count++;
            }
        }
        // If stack2 still empty, the queue is empty
        if (stack2.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        // Return the top item from stack2
        count--;
        return stack2.pop();
    }

}

/*
We could keep track of the number of items that have been dequeued from stack2 using a variable count.
Each time an item is dequeued from stack2, we increment count.
When a new item is enqueued, we check if count is greater than zero.
If it is, we decrement count and do not push the item onto stack1.

This way, when the next dequeue operation is called, stack2 will already have the correct number of items,
so we can simply pop an item from the top of stack2.

This optimization reduces the number of items that need to be moved between stack1 and stack2
and therefore the amortized time complexity of the dequeue operation becomes O(1) on average,
because the worst case scenario is when all operations are dequeues and the time complexity of each dequeue is O(1).
 */
