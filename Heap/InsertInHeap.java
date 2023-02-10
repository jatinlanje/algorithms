class InsertInHeap {
    ArrayList<Integer> list = new ArrayList<>();

    // Insert a new value into the heap
    public void insert(int value) {
    	// Add the new value to the end of the list
        list.add(value);
        int index = list.size() - 1;

        // Compare the new node with its parent and swap if necessary
        while (index > 0) {
        	// Calculate the index of the parent node
            int parentIndex = (index - 1) / 2;
            if (list.get(index) < list.get(parentIndex)) { //for maxHeap change the sign to >
            	// Swap the new node with its parent if it's smaller
                swap(index, parentIndex);
                index = parentIndex;
            } else {
            	// The new node is in the correct position, so we can stop here
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
