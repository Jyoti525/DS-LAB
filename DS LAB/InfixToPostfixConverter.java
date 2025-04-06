import java.util.Stack;

public class InfixToPostfixConverter {

    public static boolean isOperand(char ch) {
        return Character.isLetter(ch);
    }

    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    // Method to convert infix to postfix
    public static String convertInfixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            
            if (isOperand(ch)) {
                result.append(ch);
            }

            // If '(', push to stack
            else if (ch == '(') {
                stack.push(ch);
            }

            // If ')', pop until '(' is encountered
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return "Invalid Expression";
                }
            }

            else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') return "Invalid Expression";
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String expression = "((a+(b*c))-d)";
        String postfix = convertInfixToPostfix(expression);
        System.out.println("Postfix Expression: " + postfix);
    }
}
