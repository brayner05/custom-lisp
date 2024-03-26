import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import lisp.Lexer;

public class Main {
    private static final String EXIT_KEYWORD = ".quit";

    public static void main(String[] args) throws IOException {
        var input = new InputStreamReader(System.in);
        var reader = new BufferedReader(input);

        while (true) {
            System.out.print("lisp > ");
            var line = reader.readLine();
            if (line.equals(EXIT_KEYWORD)) {
                return;
            }

            var lexer = new Lexer(line);
            var tokens = lexer.tokenize();
            for (var token : tokens) {
                System.out.println(token);
            }
        }
    }
}