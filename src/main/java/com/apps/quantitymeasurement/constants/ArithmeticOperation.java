package main.java.com.apps.quantitymeasurement.constants;

import java.util.function.DoubleBinaryOperator;

public enum ArithmeticOperation {
    ADD(Double::sum),
    SUBTRACT((a,b)->a-b),
    DIVIDE((a,b)->{
        if(b == 0.0) throw new ArithmeticException("Please enter non zero value for division, Dividing by zero");
        return a / b;
    }),
    MULTIPLY((a,b)->{
        if(b==0.0) throw new ArithmeticException("Please enter non zero value, Multiplying by zero");
        return a * b;
    });

    private final DoubleBinaryOperator operation;

    ArithmeticOperation(DoubleBinaryOperator operation) {
        this.operation = operation;
    }

    public String getOperationName(){return this.getClass().getName();}

    public double compute(double a, double b){
        return operation.applyAsDouble(a,b);
    }

    public String getUnitName() {
        return this.name();
    }
}
