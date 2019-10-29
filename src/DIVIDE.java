public class DIVIDE extends LexerRule {
    public DIVIDE() {
        super("/");
        type = Token.TokenType.DIVIDE;
    }
}
