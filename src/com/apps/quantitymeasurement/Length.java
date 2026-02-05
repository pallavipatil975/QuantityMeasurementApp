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

    // converted Length into targetUnit
    public Length convertTo(LengthUnit tragetUnit){
        if(tragetUnit == null){
            throw new IllegalArgumentException("target unit must not be null");
        }
        double inches = convertToBaseUnit();
      double convertedValue = inches / tragetUnit.getConversionFactor();
       convertedValue =  Math.round(convertedValue*100.00)/100.0;
        return new Length(convertedValue, tragetUnit);
    }

    //compare two length objects
    public boolean compare(Length thatLength) {
        return Double.
                compare(this.convertToBaseUnit(),
                        thatLength.convertToBaseUnit()) == 0;
    }

    //addition of two units and converted into first unit
    public Length add(Length thatLength){

        if(thatLength == null){
            throw new IllegalArgumentException("null is not allowed, please enter valid number");
        }
        Length length1 =  convertFromBaseToTargetUnit(this, thatLength);
        double length2 = length1.value +  this.value;;
        return new Length(length2, this.unit);
    }

    //addition of two length values and converted into specified target unit
    public Length addAndConvert(Length value, LengthUnit targetUnit){
         return this.add(value, targetUnit);
    }

    // addition of current value with new value and converted into target unit
    private Length add(Length value, LengthUnit targetUnit) {
           return this.add(value).convertTo(targetUnit);
    }
    // converted from base unit to traget unit
    public Length convertFromBaseToTargetUnit(Length length, Length thatLength) {
        
        return thatLength.convertTo(length.unit);
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

        System.out.println("length converter :" + length3.convertTo(LengthUnit.CENTIMETER).toString());

        System.out.println("addition of 2 length units : " + length1.add(length3).toString());

        System.out.println("addition of 2 length units with conversion into target : " + length1.addAndConvert(length3, LengthUnit.CENTIMETER).toString());


    }
}
