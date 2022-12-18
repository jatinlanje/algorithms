public class BinarySearch { 
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9};
        System.out.println(binarysearch(arr,9));
    }

    public static int binarysearch(int[] array, int k ) {
        //define your search space
        int left=0;
        int right=array.length-1;
        while(left<=right) {
            int mid = (left + right) / 2;
            if (array[mid] == k) { //are you the one?
                return mid;
            } else if (array[mid] < k) { //if the element at the midpoint is less than the element we're looking for
                left = mid + 1; //reject the left half
            } else if (array[mid] > k) { //if the element at the midpoint is more than the element we're looking for
                right = mid - 1; //reject the right half
            }
        }
        return -1;
    }
}
