public class NUMBER extends LexerRule {
    public NUMBER() {
        super("[0-9]*\\.?[0-9]+");
        type = Token.TokenType.NUMBER;
    }
}
