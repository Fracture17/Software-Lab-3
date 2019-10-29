public class DIVIDE extends LexerRule {
    public DIVIDE() {
        //escape because \ is special in regex
        super("\\\\");
        type = Token.TokenType.DIVIDE;
    }
}
