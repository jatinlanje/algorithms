public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        System.out.println("Input Array: " + Arrays.toString(arr));
        HeapSort.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
    public static void sort(int[] arr) {
        int n = arr.length;

        // Build a max-heap from the input array
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from the max-heap one by one
        for (int i = n - 1; i >= 0; i--) {
            // Move the current maximum element to the end of the array
            swap(arr, 0, i);

            // Maintain the max-heap property
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) { //O(log N)
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Find the largest among the root and its children
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If the root is not the largest, swap it with the largest and heapify the sub-tree
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) { //O(1)
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

//each extraction from the max-heap takes O(log n) time, and the total number of extractions is N, leading to an overall time complexity of O(N log N)
