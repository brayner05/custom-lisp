package lisp;

import java.util.List;
import java.util.Stack;

public class Parser {
    private final List<Token> tokens;
    private int current = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void eval() {
        while (!isAtEnd()) {
            Token next = nextToken();
        }
    }

    private Token peek() {
        return tokens.get(current);
    }

    private Token nextToken() {
        return tokens.get(current++);
    }

    private boolean isAtEnd() {
        return current >= tokens.size();
    }

    /***
     * + 1 (- 2 3)
     * 
     * 
     *     (+)
     *    /   \
     *   1    (-)
     *       /   \
     *      2     3
     * 
     * Algorithm Outline
     * -----------------
     * Let E be an expression
     * K = E_next
     * If K is an operator or a function, push K onto Operator Stack
     */
}
