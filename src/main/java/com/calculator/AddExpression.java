package com.calculator;

public class AddExpression extends BinaryExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double eval() {
        return left.eval() + right.eval();
    }
}
