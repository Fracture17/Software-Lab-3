import java.util.ArrayList;

public class Parser {
    private ArrayList<Token> tokens;
    private int current;

    public Expression parse(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.tokens.add(new Token("", Token.TokenType.EOF));
        current = 0;

        return expression();
    }

    private Expression expression() {
        return addition();
    }

    private boolean match(Token.TokenType... types) {
        for (Token.TokenType type : types) {
            if (check(type)) {
                advance();
                return true;
            }
        }

        return false;
    }

    private boolean check(Token.TokenType type) {
        if (isAtEnd()) return false;
        return peek().getType() == type;
    }

    private void advance() {
        if (!isAtEnd()) {
            current++;
        }
    }

    private boolean isAtEnd() {
        return peek().getType() == Token.TokenType.EOF;
    }

    private Token peek() {
        return tokens.get(current);
    }

    private Token previous() {
        return tokens.get(current - 1);
    }

    private Expression addition() {
        Expression expr = multiplication();

        while (match(Token.TokenType.PLUS, Token.TokenType.MINUS)) {
            Token operator = previous();
            Expression right = multiplication();
            switch (operator.getType()) {
                case PLUS:
                    expr = new AddExpression(expr, right);
                    break;
                case MINUS:
                    expr = new SubtractExpression(expr, right);
                    break;
            }
        }

        return expr;
    }

    private Expression multiplication() {
        Expression expr = unary();

        while (match(Token.TokenType.MULTIPLY, Token.TokenType.DIVIDE,
                Token.TokenType.MOD)) {
            Token operator = previous();
            Expression right = unary();
            switch (operator.getType()) {
                case MULTIPLY:
                    expr = new MultiplyExpression(expr, right);
                    break;
                case DIVIDE:
                    expr = new DivideExpression(expr, right);
                    break;
                case MOD:
                    expr = new ModExpression(expr, right);
                    break;
            }
        }

        return expr;
    }

    private Expression unary() {
        if (match(Token.TokenType.MINUS)) {
            Expression right = unary();
            return new UnaryNegativeExpression(right);
        }

        return primary();
    }

    private Expression primary() {
        if (match(Token.TokenType.NUMBER)) {
            return new NumberExpression(Double.parseDouble(previous().evaluate()));
        }

        throw new RuntimeException("Unexpected token: " + peek().evaluate());
    }
}
