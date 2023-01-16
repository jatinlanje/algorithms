import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElementOnLeft {
    public static void main(String[] args) {
        int arr[]=new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nearestSmallerElementOnLeft(arr)));
    }

    public static int[] nearestSmallerElementOnLeft(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        //iterate through the input array
        for (int i = 0; i < arr.length; i++) {
            //pop elements from stack while they are greater than or equal to the current element
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            //if stack is empty, set res[i] to -1
            if(stack.isEmpty()){ //res[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
                res[i]=-1;
            }
            //else set res[i] to the top element of stack
            else{
                res[i]=stack.peek();
            }
            //push current element to stack
            stack.push(arr[i]);
        }
        return res;
    }
}
