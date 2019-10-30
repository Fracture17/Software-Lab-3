package com.calculator;

import java.util.ArrayList;

public class Lexer {
    private LexerRule[] rules;

    public ArrayList<Token> lex(String string) {
        int i = 0;
        ArrayList<Token> result = new ArrayList<>();
        while(i < string.length()) {
            boolean matched = false;
            for(LexerRule rule: rules) {
                Token match = rule.match(string.substring(i));
                if(match != null) {
                    if(!rule.shouldSkip()) {
                        result.add(match);
                    }
                    i += match.size();
                    matched = true;
                    break;
                }
            }
            if(!matched) {
                throw new RuntimeException("Unexpected character: " + string.substring(i, i+1) +
                        " at index " + Integer.toString(i));
            }
        }
        return result;
    }

    public void setRules(LexerRule[] rules) {
        this.rules = rules;
    }
}
