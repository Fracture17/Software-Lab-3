import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

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
}
