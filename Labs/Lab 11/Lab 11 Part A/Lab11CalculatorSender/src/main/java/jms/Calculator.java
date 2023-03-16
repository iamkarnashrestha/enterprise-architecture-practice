package jms;

public class Calculator {
    private double value;
    private char operator;

    public Calculator(){}
    public Calculator(double value, char operator) {
        this.value = value;
        this.operator = operator;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }
}
