package com.calculator;

public class MultiplyExpression extends BinaryExpression {
    public MultiplyExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double eval() {
        return left.eval() * right.eval();
    }
}
