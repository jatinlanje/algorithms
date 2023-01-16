import java.util.Arrays;
import java.util.Stack;

public class DistanceNearestSmallerElementOnRight {
    public static void main(String[] args) {
        int arr[]=new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(distanceNearestSmallerElementOnRight(arr)));
    }
    public static int[] distanceNearestSmallerElementOnRight(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        // Iterate the array from the last element to the first
        for (int i = arr.length-1; i >= 0; i--) {
            // While stack is not empty and the top element of the stack is greater or equal to the current element
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // If the stack is empty, set the result to -1
            if (stack.isEmpty()) {
                result[i] = -1;
            } 
            // Else set the result to the difference between the current element index and the top element of the stack
            else {
                result[i] = stack.peek()-i;
            }
            // Push the current element index onto the stack
            stack.push(i);
        }
        return result;
    }
}

