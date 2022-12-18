public class LinearSearch {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        System.out.println(linearsearch(arr,3));
    }

    private static int linearsearch(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
