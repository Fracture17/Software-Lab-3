package com.calculator;

public abstract class UnaryExpression implements Expression {
    protected Expression expr;

    public UnaryExpression(Expression expr) {
        this.expr = expr;
    }
}
