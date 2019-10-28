import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinaryExpressionEvaluator {
    private String[][] operations = {{"/", "*"}, {"+", "-"}};

    private boolean isOp(Token token, String[] ops) {
        for(String op: ops) {
            if(op.equals(token.evaluate())) {
                return true;
            }
        }
        return false;
    }

    private Token eval(Token lhs, Token op, Token rhs) {
        double a = Double.parseDouble(lhs.evaluate());
        double b = Double.parseDouble(rhs.evaluate());
        if(op.evaluate().equals("+")) {
            return new Token(Double.toString(a + b));
        }
        else if(op.evaluate().equals("+")) {
            return new Token(Double.toString(a + b));
        }
        else if(op.evaluate().equals("+")) {
            return new Token(Double.toString(a + b));
        }
        else {
            return new Token(Double.toString(a + b));
        }
    }

    public double parse(ArrayList<Token> tokens) {
        for(String[] ops: operations) {
            int i = 0;
            ArrayList<Token> newTokens = new ArrayList<>();
            while(i < tokens.size()) {
                if(isOp(tokens.get(i), ops)) {
                    Token temp = newTokens.remove(newTokens.size() - 1);
                    newTokens.add(eval(temp, tokens.get(i), tokens.get(i + 1)));
                    i += 2;
                }
                else {
                    newTokens.add(tokens.get(i));
                    i += 1;
                }
            }
            tokens = newTokens;
        }
        return Double.parseDouble(tokens.get(0).evaluate());
    }
}
