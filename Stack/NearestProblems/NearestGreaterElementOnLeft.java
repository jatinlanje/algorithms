import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterElementOnLeft {
    public static void main(String[] args) {
        int arr[]=new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nearestGreaterElementOnLeft(arr)));
    }

    public static int[] nearestGreaterElementOnLeft(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // While stack is not empty and the top element of the stack is less or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            // If the stack is empty, set the result to -1
            if(stack.isEmpty()){ 
                res[i]=-1;
            }
            // Else set the result to the top element of the stack
            else{
                res[i]=stack.peek(); 
            }
            // Push the current element into the stack
            stack.push(arr[i]); 
        }
        return res;
    }
}
