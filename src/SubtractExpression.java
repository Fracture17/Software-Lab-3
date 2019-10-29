public class SubtractExpression extends BinaryExpression {
    public SubtractExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double eval() {
        return left.eval() - right.eval();
    }
}
