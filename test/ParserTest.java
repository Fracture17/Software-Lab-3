import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void basicAddition() {
        Parser parser = new Parser();

        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token("1", Token.TokenType.NUMBER));
        tokens.add(new Token("+", Token.TokenType.PLUS));
        tokens.add(new Token("2", Token.TokenType.NUMBER));

        assertEquals(3.0, parser.parse(tokens).eval(), .01);

        tokens = new ArrayList<>();
        tokens.add(new Token("7", Token.TokenType.NUMBER));
        tokens.add(new Token("+", Token.TokenType.PLUS));
        tokens.add(new Token("9", Token.TokenType.NUMBER));
        tokens.add(new Token("+", Token.TokenType.PLUS));
        tokens.add(new Token("12", Token.TokenType.NUMBER));

        assertEquals(28.0, parser.parse(tokens).eval(), .01);
    }
}
