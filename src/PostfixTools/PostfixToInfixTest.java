package PostfixTools;

class PostfixToInfixTest {

    @org.junit.jupiter.api.Test
    public void noBrac() {
        String testExp = "abc*+d+";
        String expectedResult = "((a+(b*c))+d)";
        assert (PostfixToInfix.calc(testExp).equals(expectedResult));
    }

    @org.junit.jupiter.api.Test
    public void Brac() {
        String testExp = "abc+*d/";
        String expectedResult = "((a*(b+c))/d)";
        assert (PostfixToInfix.calc(testExp).equals(expectedResult));
    }
}