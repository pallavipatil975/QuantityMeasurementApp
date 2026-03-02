package main.java.com.apps.quantitymeasurement.service;

import main.java.com.apps.quantitymeasurement.constant.LengthUnit;
import main.java.com.apps.quantitymeasurement.constant.VolumeUnit;
import main.java.com.apps.quantitymeasurement.constant.WeightUnit;

public class Quantity<U extends Imeasurable> {
    private double value;
    private U unit;

    public Quantity(double value, U unit) {
        if (unit == null) {
            throw new IllegalArgumentException("weightUnit cannot be null");
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

        if (other == null) {
            throw new IllegalArgumentException("null is not allowed please enter valid Unit");
        }
        double unit1 = this.getUnit().convertToBaseUnit(this.getValue());
        double unit2 = other.getUnit().convertToBaseUnit(other.getValue());
        double addU1U2 = unit1 + unit2;
        return new Quantity<>(this.getUnit().convertFromBaseUnit(addU1U2), this.getUnit());
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        Quantity<U> q1 = this.add(other);
        return new Quantity<U>(targetUnit.convertFromBaseUnit(q1.getUnit().convertToBaseUnit(q1.getValue())), targetUnit);
    }

    public Quantity<U> addAndConvert(Quantity<U> value, U targetUnit) {
        return this.add(value, targetUnit);
    }

    //compare two  objects
    public int compare(Quantity<U> unit) {
        return Double
                .compare(this.getUnit().convertToBaseUnit(this.getValue()),
                        unit.getUnit().convertToBaseUnit(unit.getValue()));
    }

    public Quantity<U> subtract(Quantity<U> other) {
        if (other == null) {
            throw new IllegalArgumentException("other Quantity cannot be null");
        }
        if ((Double.isNaN(this.getValue())|| Double.isNaN(other.getValue())) &&
                (Double.isInfinite(this.getValue())|| Double.isInfinite(other.getValue())))
        {
            throw new IllegalArgumentException("enter valid number");
        }
        if (this.getUnit() == null || other.getUnit() == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if(!this.unit.getClass().equals(other.unit.getClass())){
            throw new IllegalArgumentException("unit are not equal");
        }

        double baseThis = this.getUnit().convertToBaseUnit(this.getValue());
        double baseOther = other.getUnit().convertToBaseUnit(other.getValue());

        double baseDiff = baseThis - baseOther;

        double resultInThisUnit = this.getUnit().convertFromBaseUnit(baseDiff);
        return new Quantity<>(resultInThisUnit, this.getUnit());
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        if (other == null) {
            throw new IllegalArgumentException("other Quantity cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("target cannot be null");
        }
        if ((Double.isNaN(this.getValue())|| Double.isNaN(other.getValue())) &&
                (Double.isInfinite(this.getValue())|| Double.isInfinite(other.getValue())))
        {
            throw new IllegalArgumentException("enter valid number");
        }
        if (this.getUnit() == null || other.getUnit() == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        Quantity<U> q1 = this.subtract(other);

        double valueInBase = q1.getUnit().convertToBaseUnit(q1.getValue());
        double converted = targetUnit.convertFromBaseUnit(valueInBase);

        return new Quantity<>(converted, targetUnit);
    }

    public double divide(Quantity<U> other) {

        if (other == null) {
            throw new IllegalArgumentException("Quantity to divide by cannot be null");
        }

        if (this.getUnit() == null || other.getUnit() == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        double thisBase = this.getUnit().convertToBaseUnit(this.getValue());
        double otherBase = other.getUnit().convertToBaseUnit(other.getValue());

        if (otherBase == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        if (!this.unit.getClass().equals(other.unit.getClass())) {
            throw new IllegalArgumentException("Units belong to different categories");
        }

        double v = thisBase / otherBase;
        return v;
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
        return compare(u)==0;
    }

    public static void main(String[] args) {
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> lengthInInches = new Quantity<>(12.0, LengthUnit.INCHES);
        boolean isEqual = lengthInFeet.equals(lengthInInches);
        System.out.println("are feet and inches length equals : " + isEqual);

        Quantity<VolumeUnit> volumeInLiter = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volumeInMilliliter = new Quantity<>(1000.0, VolumeUnit.MILLILITER);
        boolean isEqual1 = volumeInLiter.equals(volumeInMilliliter);
        System.out.println("are liter and milliliter Volume equals : " + isEqual1);

        Quantity<VolumeUnit> volumeInGallon = new Quantity<>(0.264172, VolumeUnit.GALLON);
        boolean isEqual2 = volumeInLiter.equals(volumeInGallon);
        System.out.println("are liter and gallon Volume equals : " + isEqual2);

        boolean isEqual3 = volumeInMilliliter.equals(volumeInGallon);
        System.out.println("are milliliter and gallon Volume equals : " + isEqual3);

        Quantity<LengthUnit> base = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> other = new Quantity<>(3.0, LengthUnit.FEET);
        Quantity<LengthUnit> diff = base.subtract(other);
        System.out.println("difference in feet and feet : " + diff);

        Quantity<VolumeUnit> volumeInLiter1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volumeInMilliliter1 = new Quantity<>(4.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> diff1 = volumeInLiter1.subtract(volumeInMilliliter1);
        System.out.println("difference in liter and liter : " + diff1);

        Quantity<WeightUnit> weightInKilogram = new Quantity<>(3.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInGram = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> diff2 = weightInKilogram.subtract(weightInGram);
        System.out.println("difference in kilogram and gram : " + diff2);

        Quantity<LengthUnit> difference = base.subtract(other, LengthUnit.INCHES);
        System.out.println("difference in feet and feet : " + difference);

        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(5, LengthUnit.FEET);

        double result = q1.divide(q2);  // 120 / 60 = 2.0
        System.out.println("division of feet to feet : " + result);
    }


}