public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = new int[]{5,4,3,2,1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //repeatedly selects the maximum element from the unsorted portion and places it at the ending of the unsorted portion
    public static void selectionSort(int[] array){
        for(int i=0; i<array.length; i++){
            //find the max index in the array and swap it with correct index(last position)
            int last=array.length-1-i;
            int maxIndex=getMaxIndex(array,0,last);
            swap(array,maxIndex,last);
        }
    }
    public static int getMaxIndex(int array[], int start, int end){
        int max=start;
        for(int i=start; i<=end; i++){
            if(array[i]>array[max]){
                max=i;
            }
        }
        return max;
    }
    public static void swap(int array[], int first, int second){
        int temp=array[first];
        array[first]=array[second];
        array[second]=temp;
    }
}
