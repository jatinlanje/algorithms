class MinHeap {
    ArrayList<Integer> list = new ArrayList<>();

    // Delete the root node from the heap
    public void delete() {
        if (list.size() == 0) {
            return;
        }
        // Replace the root node with the last leaf node
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        // Compare the root node with its children and swap if necessary
        int index = 0;
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallestChildIndex = index;
            if (leftChildIndex < list.size() && list.get(leftChildIndex) < list.get(smallestChildIndex)) {
                smallestChildIndex = leftChildIndex;
            }
            if (rightChildIndex < list.size() && list.get(rightChildIndex) < list.get(smallestChildIndex)) {
                smallestChildIndex = rightChildIndex;
            }
            if (smallestChildIndex != index) {
                swap(index, smallestChildIndex);
                index = smallestChildIndex;
            } else {
                break;
            }
        }
    }

    // Swap two values in the heap
    private void swap(int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}
