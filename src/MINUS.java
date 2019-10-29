public class MINUS extends LexerRule {
    public MINUS() {
        super("-");
        type = Token.TokenType.MINUS;
    }
}
