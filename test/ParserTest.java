import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void basicAddition() {
        BinaryExpressionEvaluator parser = new BinaryExpressionEvaluator();

        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token("1"));
        tokens.add(new Token("+"));
        tokens.add(new Token("2"));

        assertEquals(3.0, parser.parse(tokens), .01);

        tokens = new ArrayList<>();
        tokens.add(new Token("7"));
        tokens.add(new Token("+"));
        tokens.add(new Token("9"));
        tokens.add(new Token("+"));
        tokens.add(new Token("12"));

        assertEquals(28.0, parser.parse(tokens), .01);
    }
}
