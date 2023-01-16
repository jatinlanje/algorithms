import java.util.Stack;

public class PrefixEvaluation {
    public static void main(String[] args) {
        String prefixExpression = "- + 2 / * 6 4 8 3";
        System.out.println("Prefix Expression: " + prefixExpression);
        System.out.println("Evaluated Result: " + evaluatePrefixExpression(prefixExpression));
    }

    public static int evaluatePrefixExpression(String expression) {
        // Initialize stack for operands
        Stack<Integer> operandStack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            // Ignore spaces
            if (c == ' ') continue;

            // If the character is a digit, push it onto the operand stack
            else if(Character.isDigit(c)) {
                operandStack.push(c - '0');
            }
            /*
            //multi digit support
            else if(Character.isDigit(c)) {
                StringBuilder operand = new StringBuilder();
                while (i >= 0 && (Character.isDigit(expression.charAt(i)))) {
                    operand.append(expression.charAt(i--));
                }
                operandStack.push(Integer.parseInt(operand.toString()));
                i++;
            }
            */
            // If the character is an operator, pop operands from the operand stack and perform the operation
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                int op1 = operandStack.pop();
                int op2 = operandStack.pop();
                operandStack.push(performOperation(op1, op2, c));
            }
        }

        // The final result will be the only remaining value on the operand stack
        return operandStack.pop();
    }

    public static int performOperation(int op1, int op2, char operator) {
        if (operator == '+') {
            return op1 + op2;
        } else if (operator == '-') {
            return op1 - op2;
        } else if (operator == '*') {
            return op1 * op2;
        } else if (operator == '/') {
            if (op2 == 0) {
                System.out.println("Cannot divide by zero");
                return 0;
            }
            return op1 / op2;
        } else if (operator == '^') {
            return (int) Math.pow(op1, op2);
        }
        return 0;
    }
}
