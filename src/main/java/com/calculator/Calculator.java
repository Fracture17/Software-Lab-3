package com.calculator;

import java.util.ArrayList;

public class Calculator {
    private LexerRule[] rules;
    private Lexer lexer;
    private Parser parser;

    public Calculator() {
        rules = new LexerRule[7];
        rules[0] = new PLUS();
        rules[1] = new MINUS();
        rules[2] = new MULTIPLY();
        rules[3] = new DIVIDE();
        rules[4] = new MODULUS();
        rules[5] = new NUMBER();
        rules[6] = new WS();

        lexer = new Lexer();
        lexer.setRules(rules);

        parser = new Parser();
    }

    public double calculate(String expression) {
        ArrayList<Token> tokens = lexer.lex(expression);
        return parser.parse(tokens).eval();
    }
}
