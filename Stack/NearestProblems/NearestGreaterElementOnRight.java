import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterElementOnRight {
    public static void main(String[] args) {
        int arr[]=new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nearestGreaterElementOnRight(arr)));
    }

    public static int[] nearestGreaterElementOnRight(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        // Iterate through the array starting from the last element
        for (int i = arr.length-1; i >= 0; i--) {
            // While stack is not empty and the top element of the stack is less or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){ // If the stack is empty, set the result to -1
                res[i]=-1;
            }
            else{
                res[i]=stack.peek(); // Else set the result to the top element of the stack
            }
            stack.push(arr[i]); // Push the current element onto the stack
        }
        return res;
    }
}
