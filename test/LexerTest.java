import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class LexerTest {
    @Test
    public void basicAddition() {
        Lexer lexer = new Lexer();
        String exp = "1 + 2";
        Token[] tokens = new Token[3];
        tokens[0] = new Token("1");
        tokens[1] = new Token("+");
        tokens[2] = new Token("2");

        assertArrayEquals(tokens, lexer.lex(exp));
    }
}
