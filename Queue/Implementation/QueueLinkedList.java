import java.util.LinkedList;

public class QueueLinkedList {
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();

        // adding elements to the queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front element is: " + queue.front());
        System.out.println("Rear element is: " + queue.rear());

        //removing elements from the queue
        queue.dequeue();
        queue.dequeue();

        System.out.println("Front element is: " + queue.front());
        System.out.println("Rear element is: " + queue.rear());
    }

    LinkedList<Integer> list = new LinkedList<>();

    // Method to add an item to the queue at tail
    public void enqueue(int item) {
        list.addLast(item);
    }

    // Method to remove an item from queue from front.
    public int dequeue() {
        if (list.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return list.removeFirst();
    }

    // Method to get front of queue
    public int front() {
        if (list.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return list.getFirst();
    }

    // Method to get rear of queue
    public int rear() {
        if (list.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return list.getLast();
    }
}
