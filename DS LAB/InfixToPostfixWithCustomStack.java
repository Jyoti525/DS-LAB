public class InfixToPostfixWithCustomStack {

    static class Stack {
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
            if (isFull()) {
                System.out.println("Will not be able to push, maxSize reached");
                return;
            }
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

    static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    static int precedence(char ch) {
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
    static String convertInfixToPostfix(String expr) {
        int len = expr.length();
        Stack stack = new Stack(len);
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char ch = expr.charAt(i);

            if (isOperand(ch)) {
                output.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression";
                } else {
                    stack.pop(); // pop '('
                }
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    output.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') return "Invalid Expression";
            output.append(stack.pop());
        }

        return output.toString();
    }

    public static void main(String[] args) {
        String expression = "((a+(b*c))-d)";
        String result = convertInfixToPostfix(expression);
        System.out.println("Postfix Expression: " + result);
    }
}
