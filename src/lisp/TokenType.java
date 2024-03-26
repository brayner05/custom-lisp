package lisp;

public enum TokenType {
    // Operators
    PLUS, MINUS, STAR, SLASH, EQUAL, MODULO, SEMICOLON,

    // Parentheses
    LPAREN, RPAREN,

    // Literals
    STRING, NUMBER, IDENTIFIER
}
