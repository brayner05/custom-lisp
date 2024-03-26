package lisp;

public class Token {
    private final TokenType type;
    private final String lexeme;
    private final Object value;
    private final int line;
    private final int column;

    public Token(int line, int column, TokenType type, String lexeme, Object value) {
        this.line = line;
        this.column = column;
        this.type = type;
        this.lexeme = lexeme;
        this.value = value;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
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
