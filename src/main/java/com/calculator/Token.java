package com.calculator;

public class Token {
    public static enum TokenType {
        PLUS,
        MINUS,
        DIVIDE,
        MULTIPLY,
        MOD,
        NUMBER,
        EOF,
        WS
    }

    private String data;
    private TokenType type;

    public Token(String data, TokenType type) {
        this.data = data;
        this.type = type;
    }

    public String evaluate() {
        return this.data;
    }

    public int size() {
        return data.length();
    }

    public TokenType getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        Token other = (Token) obj;
        return this.evaluate().equals(other.evaluate());
    }
}