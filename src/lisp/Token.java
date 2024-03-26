package lisp;

public class Token {
    private final TokenType type;
    private final String lexeme;
    private final Object value;

    public Token(TokenType type, String lexeme, Object value) {
        this.type = type;
        this.lexeme = lexeme;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public String getLexeme() {
        return lexeme;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "[Token] type: " + type + ", lexeme: " + lexeme + ", value: " + value;
    }
}
