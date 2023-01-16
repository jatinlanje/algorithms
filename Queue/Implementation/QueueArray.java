class QueueArray {
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);

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

    int front, rear, size;
    int capacity;
    int array[];

    // Constructor to initialize the queue with a given capacity
    public QueueArray(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }

    // Function to check if the queue is full
    boolean isFull(QueueArray queue) {
        return (queue.size == queue.capacity);
    }

    // Function to check if the queue is empty
    boolean isEmpty(QueueArray queue) {
        return (queue.size == 0);
    }

    // Function to add an item to the queue
    void enqueue(int item) {
        if (isFull(this)) {
            System.out.println("Queue is full, cannot add more elements");
            return;
        }
        this.rear = (this.rear + 1) % this.capacity; // This is to implement circular queue
        this.array[this.rear] = item;
        this.size = this.size + 1;
        System.out.println(item + " enqueued to queue");
    }

    // Function to remove an item from the queue
    int dequeue() {
        if (isEmpty(this)) {
            System.out.println("Queue is empty, cannot dequeue");
            return Integer.MIN_VALUE;
        }
        int item = this.array[this.front];
        this.front = (this.front + 1) % this.capacity; // This is to implement circular queue
        this.size = this.size - 1;
        return item;
    }

    // Function to get the front element of the queue
    int front() {
        if (isEmpty(this)) {
            System.out.println("Queue is empty, cannot get front element");
            return Integer.MIN_VALUE;
        }
        return this.array[this.front];
    }

    // Function to get the rear element of the queue
    int rear() {
        if (isEmpty(this)) {
            System.out.println("Queue is empty, cannot get rear element");
            return Integer.MIN_VALUE;
        }
        return this.array[this.rear];
    }
}
