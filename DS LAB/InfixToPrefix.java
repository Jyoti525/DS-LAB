import java.util.*;

class Stack {
    int top;
    int maxSize;
    char[] array;

    Stack(int max) {
        this.maxSize = max;
        this.top = -1;
        this.array = new char[maxSize];
    }

    boolean isFull() {
        return top == maxSize - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(char item) {
        if (!isFull())
            array[++top] = item;
    }

    char pop() {
        if (isEmpty())
            return Character.MIN_VALUE;
        return array[top--];
    }

    char peek() {
        if (isEmpty())
            return Character.MIN_VALUE;
        return array[top];
    }
}

public class InfixToPrefix {

    static boolean checkIfOperand(char ch) {
        return Character.isLetter(ch);
    }

    static int precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    static String getPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack stack = new Stack(expression.length());

        for (int i = 0; i < expression.length(); ++i) {
            char ch = expression.charAt(i);

            if (checkIfOperand(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return "Invalid Expression";
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()))
                    result.append(stack.pop());
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    static String reverse(String exp) {
        return new StringBuilder(exp).reverse().toString();
    }

    static String swapBrackets(String exp) {
        char[] chars = exp.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') chars[i] = ')';
            else if (chars[i] == ')') chars[i] = '(';
        }
        return new String(chars);
    }

    static String infixToPrefix(String exp) {
        exp = reverse(exp);
        exp = swapBrackets(exp);
        String postfix = getPostfix(exp);
        return reverse(postfix);
    }

    public static void main(String[] args) {
        String expression = "((a/b)+c)-(d+(e*f))";
        System.out.println("The infix is: " + expression);
        String prefix = infixToPrefix(expression);
        System.out.println("The prefix is: " + prefix);
    }
}
