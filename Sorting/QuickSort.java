public class LearnQuickSort {
    public static void main(String[] args) {
        int arr[] ={5,4,3,2,1};
        quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    //selecting a "pivot" element from the array and partitioning the other elements into two sub arrays according to whether they are less than or greater than the pivot. The sub arrays are then sorted recursively.
    public static void quicksort(int array[], int start, int end){
        if(start>=end){
            return;
        }
        int p=partition(array,start,end);
        quicksort(array,start,p-1);
        quicksort(array,p+1,end);
    }
    // smaller than pivot(arr[low]) are on the left and elements greater than pivot are on the right.
    public static int partition(int[] array, int low, int high) { //partition of sub array
        int start=low+1;
        int end=high;
        while(start<=end) {
            if (array[start] <= array[low]) { //no violation
                // If element is smaller than pivot, move to the right
                start++;
            } else if (array[end] > array[low]) { //no violation
                // If element is greater than pivot, move to the left
                end--;
            } else { //violation
                swap(array, start, end);
                start++;
                end--;
            }
        }
        swap(array,low,end); // Swap pivot with the correct position
        return end;
    }
    public static void swap(int array[], int first, int second){
        int temp = array[first];
        array[first]=arr[second];
        array[second]=temp;
    }
}
