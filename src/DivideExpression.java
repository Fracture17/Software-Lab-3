public class DivideExpression extends BinaryExpression {
    public DivideExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double eval() {
        return left.eval() / right.eval();
    }
}
