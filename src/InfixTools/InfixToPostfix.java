package InfixTools;

import java.util.Stack;

public class InfixToPostfix {
    static int precedence(Character ch) {
        if (ch == '^') {
            return 3;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return -1;
        }
    }

    static public String calc(String exp) {
        Stack<Character> st = new Stack<>();
        String out = "";
        for (int i = 0; i < exp.length(); i++) {
            Character ch = exp.charAt(i);
            if (precedence(ch) == -1) {
                switch (ch) {
                    case '(':
                        st.push(ch);
                        break;
                    case ')':
                        while (st.peek() != '(') {
                            out += st.pop();
                        }
                        st.pop();
                        break;
                    default:
                        out += ch;
                        break;
                }
            } else if (st.empty()) {
                st.push(ch);
            } else {
                while (!st.empty() && precedence(st.peek()) >= precedence(ch)) {
                    out += st.pop();
                }
                st.push(ch);
            }
        }
        while (!st.empty()) {
            out += st.pop();
        }
        return out;
    }
}
