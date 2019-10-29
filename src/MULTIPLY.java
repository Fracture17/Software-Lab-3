public class MULTIPLY extends LexerRule {
    public MULTIPLY() {
        //escape because * is special in regex
        super("\\*");
        type = Token.TokenType.MULTIPLY;
    }
}
