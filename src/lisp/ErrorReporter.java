package lisp;

public class ErrorReporter {
    private static boolean hadError = false;

    public static void error(int line, String message) {
        System.out.println("(Error on line " + line + "): " + message);
        hadError = true;
    }

    public boolean hadError() {
        return hadError;
    }
}
