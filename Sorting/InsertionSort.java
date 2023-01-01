public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = new int[]{5,4,3,2,1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //builds the final sorted array, one element at a time by inserting each element in the correct position in the already sorted portion
    public static void insertionSort(int array[]){
        for(int i=0; i<array.length-1; i++){
            for(int j=i+1; j>0; j--){
                if(array[j]<array[j-1]){
                    swap(array,j,j-1);
                }
                else{
                    break;
                }
            }
        }
    }
    public static void swap(int array[], int first, int second){
        int temp=array[first];
        array[first]=array[second];
        array[second]=temp;
    }
}
