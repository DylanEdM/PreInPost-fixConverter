package InfixTools;

class InfixToPostfixTest {

    @org.junit.jupiter.api.Test
    public void noBrac() {
        String testExp = "((a+(b*c))+d)";
        String expectedResult = "abc*+d+";
        assert (InfixToPostfix.calc(testExp).equals(expectedResult));
    }

    @org.junit.jupiter.api.Test
    public void Brac() {
        String testExp = "((a*(b+c))/d)";
        String expectedResult = "abc+*d/";
        assert (InfixToPostfix.calc(testExp).equals(expectedResult));
    }
}