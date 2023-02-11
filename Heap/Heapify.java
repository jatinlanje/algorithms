//to convert an unordered array into a heap in O(n) time
public class Heapify {
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        System.out.println("Input Array: " + Arrays.toString(arr));
        MinHeap minHeap = new MinHeap(arr);
        System.out.println("Minimum Element: " + minHeap.getMinimum());
    }

    public static class MinHeap {
        private int[] arr;
        private int size;

        public MinHeap(int[] arr) {
            this.arr = arr;
            this.size = arr.length;
            buildHeap();
        }

        private void buildHeap() { //O(N) because the buildHeap method loops through all the non-leaf nodes in the array and calls the heapify function on each node
            // Start from the last non-leaf node
            int start = (size / 2) - 1;
            for (int i = start; i >= 0; i--) {
                heapify(i);
            }
        }

        private void heapify(int i) { //O(log N)
            int smallest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // If the left child is smaller than the root
            if (left < size && arr[left] < arr[smallest])
                smallest = left;

            // If the right child is smaller than the smallest so far
            if (right < size && arr[right] < arr[smallest])
                smallest = right;

            // If the smallest is not the root
            if (smallest != i) {
                // Swap the root with the smallest
                swap(i, smallest);

                // Recursively heapify the affected sub-tree
                heapify(smallest);
            }
        }

        private void swap(int a, int b) { //O(1)
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        public int getMinimum() { //O(1)
            return arr[0];
        }
    }
}

//Therefore, the overall time complexity of building a min-heap is O(N) + O(N log N) = O(N log N)
