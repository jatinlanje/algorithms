import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerIndexOnLeft {
    public static void main(String[] args) {
        int arr[]=new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nearestSmallerIndexOnLeft(arr)));
    }
    public static int[] nearestSmallerIndexOnLeft(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        //iterate through the input array
        for (int i = 0; i < arr.length; i++) {
            //pop elements from stack while they are greater than or equal to the current element
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            //if stack is empty, set result[i] to -1
            if (stack.isEmpty()) {
                result[i] = -1;
            //else set result[i] to the top index of stack
            } else {
                result[i] = stack.peek();
            }
            //push current index to stack
            stack.push(i);
        }
        return result;
    }
}
