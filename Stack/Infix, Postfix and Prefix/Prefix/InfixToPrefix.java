import java.util.Stack;

public class InfixToPrefix {

    public static String convert(String infix) {
        // Initialize an empty stack and output string
        Stack<Character> stack = new Stack<Character>();
        StringBuilder output = new StringBuilder();

        // Iterate through each character in the infix expression
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            // If the current character is an operand, add it to the output string
            if (Character.isLetterOrDigit(c)) {
                output.append(c);
            }
            // If the current character is an operator
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    output.append(stack.pop());
                }
                stack.push(c);
            }
            // If the current character is an open parenthesis, push it to the stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the current character is a closed parenthesis
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression";
                } else {
                    stack.pop();
                }
            }
        }
        // Pop any remaining operators from the stack and add them to the output string
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }
        // Reverse the output string to get the prefix expression
        return output.reverse().toString();
    }

    // Function to return precedence of operators
    public static int precedence(char ch){
        if(ch =='^'){
            return 3;
        }else if(ch =='*' || ch =='/'){
            return 2;
        }else if(ch =='+' || ch =='-'){
            return 1;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        String infix = "(a+b)*(c+d)";
        System.out.println(convert(infix)); //*+dc+ba
    }
}

/*
//checks for unbalanced parentheses and returns an error message if any are found.
import java.util.Stack;

public class InfixToPrefix {

    public static String convert(String infix) {
        // Initialize an empty stack and output string
        Stack<Character> stack = new Stack<Character>();
        StringBuilder output = new StringBuilder();

        // Iterate through each character in the infix expression
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            // If the current character is an operand, add it to the output string
            if (Character.isLetterOrDigit(c)) {
                output.append(c);
            }
            // If the current character is an operator
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    output.append(stack.pop());
                }
                stack.push(c);
            }
            // If the current character is an open parenthesis, push it to the stack
            else if (c == '(') {
                stack.push(c);
            }
            // If the current character is a closed parenthesis
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression: Unbalanced Parenthesis";
                } else {
                    stack.pop();
                }
            }
            // If the current character is whitespace, ignore it
            else if (c == ' ') {
                continue;
            }
            // If the current character is anything else, return an error message
            else {
                return "Invalid Expression: Invalid Character";
            }
        }
        // Check for unbalanced parenthesis
        if (!stack.empty() && stack.peek() == '(') {
            return "Invalid Expression: Unbalanced Parenthesis";
        }
        // Pop any remaining operators from the stack and add them to the output string
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }
        // Reverse the output string to get the prefix expression
        return output.reverse().toString();
    }

    // Function to return precedence of operators
    public static int precedence(char ch){
        if(ch =='^'){
            return 3;
        }else if(ch =='*' || ch =='/'){
            return 2;
        }else if(ch =='+' || ch =='-'){
            return 1;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        String infix = "(a+b)*(c+d)";
        System.out.println(convert(infix));
    }
}

 */
