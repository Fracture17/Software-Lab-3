public class DivideExpression extends BinaryExpression {
    public DivideExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double eval() {
        if(right.eval() == 0) {
            throw new ArithmeticException();
        }
        return left.eval() / right.eval();
    }
}
