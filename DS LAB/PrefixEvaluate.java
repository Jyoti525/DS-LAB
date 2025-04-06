import java.util.Stack;

public class PrefixEvaluate {

    static boolean isOperand(char c) {
        return Character.isDigit(c);  
    }

    static double evaluatePrefix(String exprsn) {
        Stack<Double> stack = new Stack<>();

        for (int j = exprsn.length() - 1; j >= 0; j--) {
            char ch = exprsn.charAt(j);

            if (isOperand(ch)) {
                stack.push((double) (ch - '0'));
            } else {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid Prefix Expression");
                }

                double operand1 = stack.pop();
                double operand2 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported Operator: " + ch);
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid Prefix Expression");
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String exprsn = "+9*26";  
        System.out.println("Result: " + evaluatePrefix(exprsn));  
    }
}
