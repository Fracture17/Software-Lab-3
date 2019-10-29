public class ModExpression extends BinaryExpression {
    public ModExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double eval() {
        return left.eval() % right.eval();
    }
}
