package main.java.com.apps.quantitymeasurement.service;

import main.java.com.apps.quantitymeasurement.constant.LengthUnit;
import main.java.com.apps.quantitymeasurement.constant.VolumeUnit;

public class Quantity<U extends Imeasurable> {
    private double value;
    private U unit;

    public Quantity(double value, U unit) {
        if(unit ==  null){
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

    public <U extends Imeasurable> double convertTo(U targetUnit){
        return targetUnit.convertFromBaseUnit(this.getValue());
    }

    public Quantity<U> add(Quantity<U> other){

        if(other == null){
            throw new IllegalArgumentException("null is not allowed please enter valid Unit");
        }
        double unit1 = this.getUnit().convertToBaseUnit(this.getValue());
        double unit2 = other.getUnit().convertToBaseUnit(other.getValue());
        double addU1U2 = unit1 + unit2;
        return new Quantity<>(this.getUnit().convertFromBaseUnit(addU1U2), this.getUnit());
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit){
        Quantity<U> q1 = this.add(other);
        return new Quantity<U>(targetUnit.convertFromBaseUnit(q1.getUnit().convertToBaseUnit(q1.getValue())),targetUnit);
    }

    public Quantity<U> addAndConvert(Quantity<U> value, U targetUnit){
        return this.add(value, targetUnit);
    }

    //compare two  objects
    public boolean compare(Quantity<U> unit){
        return Double
                .compare(this.getUnit().convertToBaseUnit(this.getValue()),
                        unit.getUnit().convertToBaseUnit(unit.getValue())) == 0;
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
        return compare(u);
    }

    public static void main(String[] args) {
        Quantity<LengthUnit> lengthInFeet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> lengthInInches = new Quantity<>(12.0, LengthUnit.INCHES);
        boolean isEqual = lengthInFeet.equals(lengthInInches);
     //   System.out.println("are feet and inches length equals : " + isEqual);

        Quantity<VolumeUnit> volumeInLiter = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> volumeInMilliliter = new Quantity<>(1000.0, VolumeUnit.MILLILITER);
        boolean isEqual1 = volumeInLiter.equals(volumeInMilliliter);
        System.out.println("are liter and milliliter Volume equals : " + isEqual1);

        Quantity<VolumeUnit> volumeInGallon = new Quantity<>(0.264172, VolumeUnit.GALLON);
        boolean isEqual2 = volumeInLiter.equals(volumeInGallon);
        System.out.println("are liter and gallon Volume equals : " + isEqual2);

        boolean isEqual3 = volumeInMilliliter.equals(volumeInGallon);
        System.out.println("are milliliter and gallon Volume equals : " + isEqual3);
    }
}