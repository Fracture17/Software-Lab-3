package com.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            System.out.println("Please enter an arithmetic expression: ");
            Scanner scanner = new Scanner(System.in);
            String expression = scanner.nextLine();
            Calculator calculator = new Calculator();
            double answer = calculator.calculate(expression);
            System.out.println(answer);
        }
    }
}
