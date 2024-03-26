package lisp;

public enum TokenType {
    // Operators
    PLUS, MINUS, STAR, SLASH, EQUAL, MODULO, SEMICOLON,
    OR, AND, NOT, PRINT,

    // Parentheses
    LPAREN, RPAREN,

    // Literals
    STRING, NUMBER, IDENTIFIER,
    
    EOF
}
