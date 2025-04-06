import java.util.Stack;

public class Test {

    static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isWhitespace(c)) {
                continue;
            }

            if (Character.isDigit(c)) {
                stack.push(c - '0'); 
            }
            
            else {
                
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid Postfix Expression");
                }

                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        if (val1 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        stack.push(val2 / val1);
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported Operator: " + c);
                }
            }
        }

        
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid Postfix Expression");
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String exp = "231*+9-";  
        System.out.println("Postfix Evaluation: " + evaluatePostfix(exp));  
    }
}
