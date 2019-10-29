import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ParserTest {
    private Parser parser;
    private Lexer lexer;
    ArrayList<Token> tokens;

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

        parser = new Parser();
        tokens = new ArrayList<>();
    }

    @Test
    public void basicAddition() {
        tokens.add(new Token("1", Token.TokenType.NUMBER));
        tokens.add(new Token("+", Token.TokenType.PLUS));
        tokens.add(new Token("2", Token.TokenType.NUMBER));

        assertEquals(3.0, parser.parse(tokens).eval(), .01);
    }

    @Test
    public void multipleAddition() {
        tokens.add(new Token("7", Token.TokenType.NUMBER));
        tokens.add(new Token("+", Token.TokenType.PLUS));
        tokens.add(new Token("9", Token.TokenType.NUMBER));
        tokens.add(new Token("+", Token.TokenType.PLUS));
        tokens.add(new Token("12", Token.TokenType.NUMBER));

        assertEquals(28.0, parser.parse(tokens).eval(), .01);
    }

    @Test
    public void subtraction() {
        String string = "2 - 7 - 1";
        double expected = -6;

        tokens = lexer.lex(string);

        assertEquals(expected, parser.parse(tokens).eval(), .01);
    }

    @Test
    public void multiplication() {
        String string = "2 * 17 * 3";
        double expected = 102;

        tokens = lexer.lex(string);

        assertEquals(expected, parser.parse(tokens).eval(), .01);
    }

    @Test
    public void division() {
        String string = "29 / 3 / 4";
        double expected = 2.417;

        tokens = lexer.lex(string);

        assertEquals(expected, parser.parse(tokens).eval(), .01);

        try {
            string = "1 / 0";
            tokens = lexer.lex(string);
            System.out.println(parser.parse(tokens).eval());

            assert false;
        }
        catch (ArithmeticException e) { }
    }

    @Test
    public void modulus() {
        String string = "17 % 7 % 2";
        double expected = 1;

        tokens = lexer.lex(string);

        assertEquals(expected, parser.parse(tokens).eval(), .01);
    }
}
