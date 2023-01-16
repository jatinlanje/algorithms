import java.util.Arrays;
import java.util.Stack;

public class NearestGreatestIndexOnLeft {
    public static void main(String[] args) {
        int arr[]=new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nearestGreatestIndexOnLeft(arr)));
    }
    public static int[] nearestGreatestIndexOnLeft(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // While stack is not empty and the top element of the stack is less or equal to the current element
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            // If the stack is empty, set the result to -1
            if (stack.isEmpty()) {
                result[i] = -1;
            } 
            // Else set the result to the index of the nearest greater element
            else {
                result[i] = stack.peek();
            }
            // Push the current element index onto the stack
            stack.push(i);
        }
        return result;
    }
}
