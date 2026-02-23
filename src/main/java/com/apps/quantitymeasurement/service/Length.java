package main.java.com.apps.quantitymeasurement.service;

import main.java.com.apps.quantitymeasurement.constant.LengthUnit;

import java.util.Objects;

public class Length {

    public double value;
    public LengthUnit lengthUnit;

    // constructor to initialize length value and unit
    public Length(double value, LengthUnit unit) {
        if(unit ==  null){
            throw new IllegalArgumentException("LengthUnit cannot be null");
        }
        this.value = value;
        this.lengthUnit = unit;
    }

    //compare two length objects
    public boolean compare(Length thatLength) {
        return Double.
                compare(this.lengthUnit.convertToBaseUnit(this.value),
                        thatLength.lengthUnit.convertToBaseUnit(thatLength.value)) == 0;
    }

    //addition of two units and converted into first unit
    public Length add(Length thatLength) {
        if (thatLength == null) {
            throw new IllegalArgumentException("null is not allowed, please enter valid number");
        }
        double inchesThis = this.lengthUnit.convertToBaseUnit(this.value);
        double inchesThat = thatLength.lengthUnit.convertToBaseUnit(thatLength.value);
        double sumInches = inchesThis + inchesThat;
     //   double sumInThisUnit = sumInches / this.lengthUnit.getConversionFactor();
     //   double sumInThisUnit = Math.round(sumInches  / this.lengthUnit.getConversionFactor())* 100.0 / 100.0;
        return new Length(sumInches, LengthUnit.INCHES);
    }

    //addition of two length values and converted into specified target unit
    public Length addAndConvert(Length value, LengthUnit targetUnit) {
        return this.add(value, targetUnit);
    }

    // addition of current value with new value and converted into target unit
    private Length add(Length value, LengthUnit targetUnit) {
        Length l1 = this.add(value);
        return new Length(targetUnit.convertFromBaseUnit(l1.value), targetUnit);
    }

    @Override
    public String toString() {
        return "Length{" +
                "value=" + value +
                ", unit=" + lengthUnit +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return compare(length);
    }

    public int hashCode() {
        return Objects.hash(this.lengthUnit.convertToBaseUnit(this.value));
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
        System.out.println("Are length equal : " + length5.equals(length6));

        System.out.println("length converter :" +  LengthUnit.FEET.convertFromBaseUnit(length3.value));

        System.out.println("addition of 2 length units : " + length1.add(length3).toString());

        System.out.println("addition of 2 length units with conversion into target : " + length1.addAndConvert(length3, LengthUnit.CENTIMETER).toString());

        System.out.println("convertToBaseUnit : " + LengthUnit.YARDS.convertToBaseUnit(3.0));

        System.out.println("convertFromBaseUnit : " +  LengthUnit.FEET.convertFromBaseUnit(1.0));
    }
}
