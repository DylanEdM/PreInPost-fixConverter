import java.util.Scanner;
import InfixTools.*;
import PrefixTools.*;
import PostfixTools.*;

void main() {
    Scanner scanner = new Scanner(System.in);
    InfixValidation infixValidator = new InfixValidation();
    PrefixValidation prefixValidator = new PrefixValidation();
    PostfixValidation postfixValidator = new PostfixValidation();
    System.out.println("Select an start expression:\nA) Infix\nB) Prefix\nC) Postfix");
    String choice = scanner.nextLine().strip().toLowerCase();
    while (!choice.matches("[abc]")) {
        System.out.println("Please input one character option");
        System.out.println("Select an start expression:\nA) Infix\nB) Prefix\nC) Postfix");
        choice = scanner.nextLine().strip().toLowerCase();
    }
    String exp = "";
    boolean valid = false;
    while (!valid) {
        System.out.println("Input expression string:");
        exp = scanner.nextLine().strip();
        switch (choice) {
            case "a":
                valid = infixValidator.infixValidation(exp);
                if (!valid) {System.out.println("Expression not valid");}
            case "b":
                valid = prefixValidator.prefixValidation(exp);
                if (!valid) {System.out.println("Expression not valid");}
            case "c":
                valid = postfixValidator.postfixValidation(exp);
                if (!valid) {System.out.println("Expression not valid");}
        }
    }
    System.out.println("Select output expression:\nA) Infix\nB) Prefix\nC) Postfix");
    choice += scanner.nextLine().strip().toLowerCase();
    while (!Character.toString(choice.charAt(1)).matches("[abc]")) {
        System.out.println("Please input one character option");
        System.out.println("Select an output expression:\nA) Infix\nB) Prefix\nC) Postfix");
        choice = choice.charAt(0) + scanner.nextLine().strip().toLowerCase();
    }
    switch (choice) {
        case "aa","bb","cc":
            System.out.println(exp);
            break;
        case "ab":
            InfixToPrefix inPre = new InfixToPrefix();
            System.out.println(inPre.calc(exp));
            break;
        case "ac":
            InfixToPostfix inPost = new InfixToPostfix();
            System.out.println(inPost.calc(exp));
            break;
        case "ba":
            PrefixToInfix preIn = new PrefixToInfix();
            System.out.println(preIn.calc(exp));
            break;
        case "bc":
            PrefixToPostfix prePost = new PrefixToPostfix();
            System.out.println(prePost.calc(exp));
            break;
        case "ca":
            PostfixToInfix postIn = new PostfixToInfix();
            System.out.println(postIn.calc(exp));
            break;
        case "cb":
            PostfixToPrefix postPre = new PostfixToPrefix();
            System.out.println(postPre.calc(exp));
            break;
    }
}
