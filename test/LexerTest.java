import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class LexerTest {
    public Lexer lexer;

    @Before
    public void setup() {
        LexerRule[] rules = new LexerRule[2];
        rules[0] = new NUMBER();
        rules[1] = new WS();

        lexer = new Lexer();
        lexer.setRules(rules);
    }

    @Test
    public void basicAddition() {
        String exp = "1 + 2";
        Token[] tokens = new Token[3];
        tokens[0] = new Token("1");
        tokens[1] = new Token("+");
        tokens[2] = new Token("2");

        assertArrayEquals(tokens, lexer.lex(exp).toArray());

        exp = "5 + 12";
        tokens[0] = new Token("5");
        tokens[1] = new Token("+");
        tokens[2] = new Token("12");

        assertArrayEquals(tokens, lexer.lex(exp).toArray());
    }

    @Test
    public void multipleAddition() {
        assert false;
    }
}
