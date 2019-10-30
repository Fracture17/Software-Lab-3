package com.calculator;

public class UnaryNegativeExpression extends UnaryExpression {
    public UnaryNegativeExpression(Expression expr) {
        super(expr);
    }

    @Override
    public double eval() {
        return -expr.eval();
    }
}
