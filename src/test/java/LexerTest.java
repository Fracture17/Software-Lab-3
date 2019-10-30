import com.calculator.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LexerTest {
    public Lexer lexer;

    @Before
    public void setup() {
        LexerRule[] rules = new LexerRule[7];
        rules[0] = new PLUS();
        rules[1] = new MINUS();
        rules[2] = new MULTIPLY();
        rules[3] = new DIVIDE();
        rules[4] = new MODULUS();
        rules[5] = new NUMBER();
        rules[6] = new WS();

        lexer = new Lexer();
        lexer.setRules(rules);
    }

    @Test
    public void basicAddition() {
        String exp = "1 + 2";
        Token[] tokens = new Token[3];
        tokens[0] = new Token("1", Token.TokenType.NUMBER);
        tokens[1] = new Token("+", Token.TokenType.PLUS);
        tokens[2] = new Token("2", Token.TokenType.NUMBER);

        assertArrayEquals(tokens, lexer.lex(exp).toArray());

        exp = "5 + 12";
        tokens[0] = new Token("5", Token.TokenType.NUMBER);
        tokens[1] = new Token("+", Token.TokenType.PLUS);
        tokens[2] = new Token("12", Token.TokenType.NUMBER);

        assertArrayEquals(tokens, lexer.lex(exp).toArray());
    }

    @Test
    public void multipleAddition() {
        String exp = "1 + 2 + 3";
        Token[] tokens = new Token[5];
        tokens[0] = new Token("1", Token.TokenType.NUMBER);
        tokens[1] = new Token("+", Token.TokenType.PLUS);
        tokens[2] = new Token("2", Token.TokenType.NUMBER);
        tokens[3] = new Token("+", Token.TokenType.PLUS);
        tokens[4] = new Token("3", Token.TokenType.NUMBER);

        assertArrayEquals(tokens, lexer.lex(exp).toArray());
    }

    @Test
    public void subtraction() {
        String exp = "1 - 2 - 3";
        Token[] tokens = new Token[5];
        tokens[0] = new Token("1", Token.TokenType.NUMBER);
        tokens[1] = new Token("-", Token.TokenType.MINUS);
        tokens[2] = new Token("2", Token.TokenType.NUMBER);
        tokens[3] = new Token("-", Token.TokenType.MINUS);
        tokens[4] = new Token("3", Token.TokenType.NUMBER);

        assertArrayEquals(tokens, lexer.lex(exp).toArray());
    }

    @Test
    public void multiplication() {
        String exp = "1 * 2 * 3";
        Token[] tokens = new Token[5];
        tokens[0] = new Token("1", Token.TokenType.NUMBER);
        tokens[1] = new Token("*", Token.TokenType.MULTIPLY);
        tokens[2] = new Token("2", Token.TokenType.NUMBER);
        tokens[3] = new Token("*", Token.TokenType.MULTIPLY);
        tokens[4] = new Token("3", Token.TokenType.NUMBER);

        assertArrayEquals(tokens, lexer.lex(exp).toArray());
    }

    @Test
    public void division() {
        String exp = "1 / 2 / 3";
        Token[] tokens = new Token[5];
        tokens[0] = new Token("1", Token.TokenType.NUMBER);
        tokens[1] = new Token("/", Token.TokenType.DIVIDE);
        tokens[2] = new Token("2", Token.TokenType.NUMBER);
        tokens[3] = new Token("/", Token.TokenType.DIVIDE);
        tokens[4] = new Token("3", Token.TokenType.NUMBER);

        assertArrayEquals(tokens, lexer.lex(exp).toArray());
    }

    @Test
    public void modulus() {
        String exp = "1 % 2 % 3";
        Token[] tokens = new Token[5];
        tokens[0] = new Token("1", Token.TokenType.NUMBER);
        tokens[1] = new Token("%", Token.TokenType.MOD);
        tokens[2] = new Token("2", Token.TokenType.NUMBER);
        tokens[3] = new Token("%", Token.TokenType.MOD);
        tokens[4] = new Token("3", Token.TokenType.NUMBER);

        assertArrayEquals(tokens, lexer.lex(exp).toArray());
    }

    @Test
    public void unaryNegative() {
        String exp = "-1";
        Token[] tokens = new Token[2];
        tokens[0] = new Token("-", Token.TokenType.MINUS);
        tokens[1] = new Token("1", Token.TokenType.NUMBER);

        assertArrayEquals(tokens, lexer.lex(exp).toArray());
    }

    @Test
    public void compoundExpression() {
        String exp = "1 + 2 * 3 - -4 / 23 % 2";
        Token[] tokens = new Token[12];
        tokens[0] = new Token("1", Token.TokenType.NUMBER);
        tokens[1] = new Token("+", Token.TokenType.PLUS);
        tokens[2] = new Token("2", Token.TokenType.NUMBER);
        tokens[3] = new Token("*", Token.TokenType.MULTIPLY);
        tokens[4] = new Token("3", Token.TokenType.NUMBER);
        tokens[5] = new Token("-", Token.TokenType.MINUS);
        tokens[6] = new Token("-", Token.TokenType.MINUS);
        tokens[7] = new Token("4", Token.TokenType.NUMBER);
        tokens[8] = new Token("/", Token.TokenType.DIVIDE);
        tokens[9] = new Token("23", Token.TokenType.NUMBER);
        tokens[10] = new Token("%", Token.TokenType.MOD);
        tokens[11] = new Token("2", Token.TokenType.NUMBER);

        assertArrayEquals(tokens, lexer.lex(exp).toArray());
    }
}
