import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        String infixExpression = "2 + 6 * 4 / 8 - 3";
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Evaluated Result: " + evaluateInfixExpression(infixExpression));
    }

    public static int evaluateInfixExpression(String expression) {
        // Initialize stacks for operands and operators
        Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // Ignore spaces
            if (c == ' ') continue;

            // If the character is a digit, push it onto the operand stack
            else if(Character.isDigit(c)) {
                operandStack.push(c - '0');
            }
            /*
            //multi digit support
            else if (Character.isDigit(c)) {
                String operand = "";
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    operand += expression.charAt(i);
                    i++;
                }
                operandStack.push(Integer.parseInt(operand));
                i--;
            }
            */
            // If the character is an operator, check its precedence and perform the operation
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                while (!operatorStack.isEmpty() && precedence(c) <= precedence(operatorStack.peek())) {
                    int op1 = operandStack.pop();
                    int op2 = operandStack.pop();
                    char operator = operatorStack.pop();
                    operandStack.push(performOperation(op2, op1, operator));
                }
                operatorStack.push(c);
            }
            // If the character is an open parenthesis, push it onto the operator stack
            else if (c == '(') {
                operatorStack.push(c);
            }
            // If the character is a close parenthesis, pop operators and perform the operation until an open parenthesis is reached
            else if (c == ')') {
                while (operatorStack.peek() != '(') {
                    int op1 = operandStack.pop();
                    int op2 = operandStack.pop();
                    char operator = operatorStack.pop();
                    operandStack.push(performOperation(op2, op1, operator));
                }
                operatorStack.pop();
            }
        }
        // Pop any remaining operators from the operator stack and perform the operation
        while (!operatorStack.isEmpty()) {
            int op1 = operandStack.pop();
            int op2 = operandStack.pop();
            char operator = operatorStack.pop();
            operandStack.push(performOperation(op2, op1, operator));
        }
        // The final result will be the only remaining value on the operand stack
        return operandStack.pop();
    }

    public static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '^') {
            return 3;
        }
        return -1;
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
