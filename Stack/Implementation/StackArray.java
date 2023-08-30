public class StackArray {
    private int stack[];
    private int size;
    private int top;

    public StackArray(int size){
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size-1;
    }

    public boolean push(int val){
        if(isFull()){
            System.out.println("Stack Overflow");
            return false;
        }
        else{
            top++;
            stack[top]=val;
            return true;
        }
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }
        else{
            int value = stack[top];
            top--;
            return value;
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }
        else{
            return stack[top];
        }
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
        }
        else{
            for(int i=top; i>=0; i--){
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}
