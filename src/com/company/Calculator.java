package com.company;

public class Calculator {

        public int calculate(int num, int num1, char operator) {
                int result;
                switch (operator) {
                case '+': result = num + num1; break;
                case '-': result = num - num1; break;
                case '*': result = num * num1; break;
                case '/': result = num / num1; break;
                default:throw  new IllegalArgumentException("Не верный знак");
        }
        return result;
}
        }
