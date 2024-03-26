package lisp;

public class ErrorReporter {
    private static boolean hadError = false;

    public static void error(int line, int column, String message) {
        System.out.println("(Error at " + (line + 1) + ":" + column + "): " + message);
        hadError = true;
    }

    public boolean hadError() {
        return hadError;
    }
}
