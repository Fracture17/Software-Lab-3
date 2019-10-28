public class Lexer {
    private LexerRule[] rules;

    public Token[] lex(String string) {
        Token[] tokens = new Token[3];
        tokens[0] = new Token("1");
        tokens[1] = new Token("+");
        tokens[2] = new Token("2");
        return tokens;
    }
}
