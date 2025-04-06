public class InfixToPrefixConverter {

    static final int MAX = 100;
    static int top = -1;
    static char[] stack = new char[MAX];

    static boolean isFull() {
        return top == MAX - 1;
    }

    static boolean isEmpty() {
        return top == -1;
    }

    static void push(char item) {
        if (!isFull()) {
            stack[++top] = item;
        }
    }

    static char pop() {
        if (!isEmpty()) {
            return stack[top--];
        }
        return Character.MIN_VALUE;
    }

    static char peek() {
        if (!isEmpty()) {
            return stack[top];
        }
        return Character.MIN_VALUE;
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

    static String getPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (isOperand(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                push(ch);
            } else if (ch == ')') {
                while (!isEmpty() && peek() != '(') {
                    result.append(pop());
                }
                if (!isEmpty() && peek() != '(') {
                    return "Invalid Expression";
                } else {
                    pop(); // remove '('
                }
            } else { // operator
                while (!isEmpty() && precedence(ch) <= precedence(peek())) {
                    result.append(pop());
                }
                push(ch);
            }
        }

        while (!isEmpty()) {
            result.append(pop());
        }

        return result.toString();
    }

    static String reverse(String exp) {
        return new StringBuilder(exp).reverse().toString();
    }

    static String swapBrackets(String exp) {
        char[] chars = exp.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                chars[i] = ')';
            } else if (chars[i] == ')') {
                chars[i] = '(';
            }
        }
        return new String(chars);
    }

    static String infixToPrefix(String exp) {
        exp = reverse(exp);
        exp = swapBrackets(exp);
        top = -1; // reset stack
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
