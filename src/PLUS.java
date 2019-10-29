public class PLUS extends LexerRule {
    public PLUS() {
        //escape because + is special in regex
        super("\\+");
        type = Token.TokenType.PLUS;
    }
}
