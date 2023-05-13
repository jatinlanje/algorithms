public class MergeSort {
    public static void main(String[] args) {
        int arr[] ={5,4,3,2,1};
        arr=mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //divide and conquer sorting algorithm that works by dividing the array of elements into smaller sub arrays, sorting the sub arrays, and then merging the sub arrays back together
    public static int[] mergeSort(int array[]) { //divide and conquer
        if(array.length==1){
            return array;
        }
        int mid = array.length/2;
        int left[] = mergeSort(Arrays.copyOfRange(array,0,mid)); //because sublist is exclusive 
        int right[] = mergeSort(Arrays.copyOfRange(array, mid, array.length));
        return merge(left, right);
    }

    public static int[] merge(int first[], int second[]){ //merge two sorted arrays
        int mix[] = new int[first.length+second.length];
        int i=0, j=0, k=0;
        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;
            }
            else{
                mix[k]=second[j];
                j++;
            }
            k++;
        }
        //it may be possible the one of the array is not complete then add all remaining elements in the mix array
        while(i<first.length){
            mix[k]=first[i];
            i++;
            k++;
        }
        while(j<second.length){
            mix[k]=second[j];
            j++;
            k++;
        }
        return mix;
    }
}
