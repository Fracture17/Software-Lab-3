import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexerRule {
    private Pattern pattern;
    private boolean skip = false;
    protected Token.TokenType type;

    public LexerRule(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public LexerRule(String pattern, boolean skip) {
        this.pattern = Pattern.compile(pattern);
        this.skip = skip;
    }

    public Token match(String expression) {
        Matcher m = pattern.matcher(expression);
        if(m.lookingAt()) {
            return new Token(m.group(0), type);
        }
        return null;
    }

    public boolean shouldSkip() {
        return skip;
    }
}
