public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = new int[]{5,4,3,2,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //bubbling the higher element to last position
    public static void bubbleSort(int[] array){
        boolean swapped;
        for(int i=0; i<array.length-1; i++){
            swapped=false;
            //for each pass/step max element will come a last respective index
            for(int j=0; j<array.length-1-i; j++){
                //swap if the current element is smaller than previous item
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    swapped=true;
                }
            }
            //if you did not swap for a particular value of i, it means the array is already sorted. Hence, stop the program
            if(!swapped){ //!false=true
                break;
            }
        }
    }
}
