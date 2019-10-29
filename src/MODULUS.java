public class MODULUS extends LexerRule {
    public MODULUS() {
        super("%");
        type = Token.TokenType.MOD;
    }
}
