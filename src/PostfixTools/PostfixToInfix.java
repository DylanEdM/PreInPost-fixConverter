package PostfixTools;

import java.util.Stack;

public class PostfixToInfix {
    static boolean isOperand(Character ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public static String calc(String exp) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            if (isOperand(exp.charAt(i))) {
                st.push(exp.charAt(i) + "");
            } else {
                String op1 = st.pop();
                String op2 = st.pop();
                st.push("(" + op2 + exp.charAt(i) + op1 + ")");
            }
        }
        return st.peek();
    }
}
