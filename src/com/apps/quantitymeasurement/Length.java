package com.apps.quantitymeasurement;

import java.util.Objects;

public class Length {

    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETER(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // constructor to initialize length value and unit
    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    // convert the length value to base unit(inches) and round off to two decimal places
    private double convertToBaseUnit() {

        double inches =  value * unit.getConversionFactor();
        return Math.round(inches* 100.00) / 100.0;
    }

    //compare two length objects
    public boolean compare(Length thatLength) {
        return Double.
                compare(this.convertToBaseUnit(),
                        thatLength.convertToBaseUnit()) == 0;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return compare(length);
    }
    public int hashCode(){
        return Objects.hash(convertToBaseUnit());
    }

    public static void main(String[] args) {

        Length length1 = new Length(12.0, LengthUnit.FEET);
        Length length2 = new Length(144.0, LengthUnit.INCHES);
        System.out.println("Are length equal?" + length1.equals(length2));

        Length length3 = new Length(1.0, LengthUnit.YARDS);
        Length length4 = new Length(36.0, LengthUnit.INCHES);
        System.out.println("Are length equal?" + length3.equals(length4));

        Length length5 = new Length(100.0, LengthUnit.CENTIMETER);
        Length length6 = new Length(39.3701, LengthUnit.INCHES);
        System.out.println("Are length equal?" + length5.equals(length6));
    }
}
