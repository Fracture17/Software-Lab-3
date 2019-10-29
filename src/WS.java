public class WS extends LexerRule {
    public WS() {
        super("[ \t\n]+", true);
        type = Token.TokenType.WS;
    }
}
