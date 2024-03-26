package lisp;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private int current = 0;
    private int start = 0;
    private int line = 0;

    public Lexer(String source) {
        this.source = source;
    }

    public List<Token> tokenize() {
        while (!isAtEnd()) {
            scanToken();
            start = current;
        }
        addToken(TokenType.EOF);
        return tokens;
    }

    private void scanToken() {
        char ch = consume();
        switch (ch) {
            case ' ', '\r', '\t' -> {}
            case '\n' -> line++;
            case ';' -> ignoreComment();
            case '(' -> addToken(TokenType.LPAREN);
            case ')' -> addToken(TokenType.RPAREN);
            case '+' -> addToken(TokenType.PLUS);
            case '-' -> addToken(TokenType.MINUS);
            case '*' -> addToken(TokenType.STAR);
            case '/' -> addToken(TokenType.SLASH);
            case '=' -> addToken(TokenType.EQUAL);
            case '%' -> addToken(TokenType.MODULO);
            case '"' -> addStringToken();
            default -> {
                if (Character.isDigit(ch)) {
                    addNumberToken();
                    break;
                }
                ErrorReporter.error(line, "Unexpected token: " + ch);
            }
        }
    }

    private void ignoreComment() {
        while (!isAtEnd() && peek() != '\n') {
            consume();
        }
    }

    private void addStringToken() {
        while (!isAtEnd() && peek() != '"') {
            consume();
        }

        if (isAtEnd()) {
            ErrorReporter.error(line, "Unterminated string");
            return;
        }

        consume();
        String literal = source.substring(start + 1, current - 1);
        addToken(TokenType.STRING, literal);
    }

    private void addNumberToken() {
        while (!isAtEnd() && Character.isDigit(peek())) {
            consume();
        }

        if (peek() == '.') {
            consume();
            while (!isAtEnd() && Character.isDigit(peek())) {
                consume();
            }
        }

        double literal = Double.parseDouble(source.substring(start, current));
        addToken(TokenType.NUMBER, literal);
    }

    private void addToken(TokenType type) {
        addToken(type, null);
    }

    private void addToken(TokenType type, Object literal) {
        String lexeme = source.substring(start, current);
        tokens.add(new Token(type, lexeme, literal));
    }

    private char consume() {
        return source.charAt(current++);
    }

    private char peek() {
        if (isAtEnd()) {
            return '\0';
        }
        return source.charAt(current);
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }
}
