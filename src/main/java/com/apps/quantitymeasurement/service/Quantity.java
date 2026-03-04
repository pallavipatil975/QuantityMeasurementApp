package main.java.com.apps.quantitymeasurement.service;

import main.java.com.apps.quantitymeasurement.constant.LengthUnit;
import main.java.com.apps.quantitymeasurement.constant.VolumeUnit;
import main.java.com.apps.quantitymeasurement.constant.WeightUnit;

public class Quantity<U extends Imeasurable> {
    private double value;
    private U unit;

    public Quantity(double value, U unit) {
        if(Double.isNaN(value) ||Double.isInfinite(value))
            throw new IllegalArgumentException("Enter valid No. ");
        if (unit == null) {
            throw new IllegalArgumentException("UNIT cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public <U extends Imeasurable> double convertTo(U targetUnit) {
        return targetUnit.convertFromBaseUnit(this.getValue());
    }

    public Quantity<U> add(Quantity<U> other) {
        return new Quantity<>(this.getUnit().convertFromBaseUnit(this.performArithmetic(other, other.getUnit(), ArithmeticOperation.ADD)), this.getUnit());
//        double resultInThisUnit = this.performArithmetic(other, this.getUnit(), ArithmeticOperation.ADD);
//        return new Quantity<>(this.getUnit().convertFromBaseUnit(resultInThisUnit), this.getUnit());
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        this.validateArithmeticOperands(other, targetUnit);
        return new Quantity<>(targetUnit.convertFromBaseUnit(this.performArithmetic(other, other.getUnit(),ArithmeticOperation.ADD)), targetUnit);
    }

    //compare two  objects
    public int compare(Quantity<U> unit) {
        return Double
                .compare(this.getUnit().convertToBaseUnit(this.getValue()),
                        unit.getUnit().convertToBaseUnit(unit.getValue()));
    }

    public Quantity<U> subtract(Quantity<U> other) {

        return new Quantity<>(this.getUnit().convertFromBaseUnit(this.performArithmetic(other, other.getUnit(),
                ArithmeticOperation.SUBTRACT)), this.getUnit());
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        this.validateArithmeticOperands(other, targetUnit);

        return new Quantity<>(targetUnit.convertFromBaseUnit(this.performArithmetic(other, other.getUnit(), ArithmeticOperation.SUBTRACT)), targetUnit);
    }

    public double divide(Quantity<U> other) {

        double resultInTarget =  this.performArithmetic(other, this.getUnit(), ArithmeticOperation.DIVIDE);
        return new Quantity<>(resultInTarget, this.getUnit()).getValue();
    }
//
//    public Quantity<U> multiply(double other) {
//        if (Double.isNaN(other) || Double.isInfinite(other)) {
//            throw new IllegalArgumentException("Enter valid number");
//        }
//
//        Quantity<U> resultInThisUnit = this.performArithmetic(other, this.getUnit(), ArithmeticOperation.MULTIPLY);
//        return new Quantity<>(this.getUnit().convertFromBaseUnit(resultInThisUnit.getValue()), this.getUnit());
//    }

    public Quantity<U> multiply(double scalar) {
        if (Double.isNaN(scalar) || Double.isInfinite(scalar)) {
            throw new IllegalArgumentException("Enter valid number");
        }
        double thisInBase = this.unit.convertToBaseUnit(this.value);
        double resultInBase = ArithmeticOperation.MULTIPLY.compute(thisInBase, scalar);
        double resultInThisUnit = this.unit.convertFromBaseUnit(resultInBase);
        return new Quantity<>(resultInThisUnit, this.unit);
    }

    @Override
    public String toString() {
        return "Length{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity<U> u = (Quantity<U>) o;
        return compare(u) == 0;
    }

    /**
     * // validation logic for arithmetic operations
     *
     * @param other      the other Quantity involved in the operation
     * @param targetUnit the targetUnit for the result (if required)
     * @throws IllegalArgumentException if validation fails
     */
    private void validateArithmeticOperands(Quantity<U> other, U targetUnit) {
        if (other == null) {
            throw new NullPointerException("other Quantity cannot be null");
        }
        if (!this.unit.getClass().equals(other.unit.getClass())) {
            throw new IllegalArgumentException("unit are not equal");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("target cannot be null");
        }
        if ((Double.isNaN(this.getValue()) || Double.isNaN(other.getValue())) &&
                (Double.isInfinite(this.getValue()) || Double.isInfinite(other.getValue()))) {
            throw new IllegalArgumentException("enter valid number");
        }
        if (this.getUnit() == null || other.getUnit() == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
    }

    public enum ArithmeticOperation {

        ADD {
            @Override
            public double compute(double thisBase, double otherBase) {
                return thisBase + otherBase;
            }
        },
        SUBTRACT {
            @Override
            public double compute(double thisBase, double otherBase) {
                return thisBase - otherBase;
            }
        },
        DIVIDE {
            @Override
            public double compute(double thisBase, double otherBase) {
                if (otherBase == 0.0) {
                    throw new ArithmeticException("enter correct number");
                }
                return thisBase / otherBase;
            }
        },
        MULTIPLY {
            @Override
            public double compute(double thisBase, double otherBase) {
                return thisBase * otherBase;
            }
        };
        public abstract double compute(double thisBase, double otherBase);
    }

    //perform arithmetic operation on the base unit values,
    //and handle addition, subtraction and division operations
    public double performArithmetic(Quantity<U> other, U targetUnit, ArithmeticOperation operation) {
       this.validateArithmeticOperands(other, targetUnit);
        return operation.compute
                (this.getUnit().convertToBaseUnit(this.getValue()),
                other.getUnit().convertToBaseUnit(other.getValue()));
    }

    public static void main(String[] args) {

        Quantity<LengthUnit> base = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> other = new Quantity<>(3.0, LengthUnit.FEET);
        Quantity<LengthUnit> diff = base.subtract(other);
        System.out.println("subtract feet from feet :...................... " + diff);

        Quantity<VolumeUnit> volumeInLiter1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volumeInMilliliter1 = new Quantity<>(4.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> diff1 = volumeInLiter1.subtract(volumeInMilliliter1);
        System.out.println("subtract liter from liter : " + diff1);

        Quantity<WeightUnit> weightInKilogram = new Quantity<>(3.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInGram = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> diff2 = weightInKilogram.subtract(weightInGram);
        System.out.println("subtract kilogram from gram : " + diff2);

        Quantity<LengthUnit> difference = base.subtract(other, LengthUnit.INCHES);
        System.out.println("subtract feet from feet : " + difference);

        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5, LengthUnit.FEET);

        double result = q1.divide(q2);
        System.out.println("division of feet to feet : " + result);

        System.out.println("multiplication is : " + q1.multiply(5));

    }


}