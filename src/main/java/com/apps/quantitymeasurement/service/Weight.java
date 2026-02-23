package main.java.com.apps.quantitymeasurement.service;

import main.java.com.apps.quantitymeasurement.constant.LengthUnit;
import main.java.com.apps.quantitymeasurement.constant.WeightUnit;

import java.util.Objects;

public class Weight {

    public double value;
    public WeightUnit weightUnit;

    public Weight(double value, WeightUnit weightUnit) {
        if(weightUnit ==  null){
            throw new IllegalArgumentException("weightUnit cannot be null");
        }
        this.value = value;
        this.weightUnit = weightUnit;
    }

    public boolean compare(Weight thatWeight) {
        return Double.compare(this.weightUnit.convertToBaseUnit(this.value),
                thatWeight.weightUnit.convertToBaseUnit(thatWeight.value)) == 0;
    }

    public Weight add(Weight weightUnit1) {
        if (weightUnit1 == null) {
            throw new IllegalArgumentException("null is not allowed please enter valid weight");
        }
        double thisGram = this.weightUnit.convertToBaseUnit(this.value);
        double thatGram = weightUnit1.weightUnit.convertToBaseUnit(weightUnit1.value);
        double grams = thisGram + thatGram;
        /*double sumInThisUnit = grams / this.weightUnit.getConversionFactor();
        sumInThisUnit = Math.round(sumInThisUnit * 100.0) / 100.0;
        return new Weight(sumInThisUnit, this.weightUnit);*/
        return new Weight(grams, WeightUnit.GRAM);
    }

    private Weight add(Weight value, WeightUnit targetUnit) {
        Weight weight1 = this.add(value);
        return new Weight(targetUnit.convertFromBaseUnit(weight1.value), targetUnit);
    }


    public Weight addAndConvert(Weight value, WeightUnit tragetUnit) {
        return this.add(value, tragetUnit);
    }

    @Override
    public String toString() {
        return "Length{" +
                "value=" + value +
                ", unit=" + weightUnit +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight = (Weight) o;
        return compare(weight);
    }

    public int hashCode() {
        return Objects.hash(this.weightUnit.convertToBaseUnit(this.value));
    }

    public static void main(String[] args) {
        Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight weight2 = new Weight(1000, WeightUnit.GRAM);
        System.out.println("are weight1 and weight2 are equals : " + weight1.equals(weight2));

        Weight weight3 = new Weight(453.59237, WeightUnit.GRAM);
        Weight weight4 = new Weight(1.0, WeightUnit.POUND);
        System.out.println("are weight3 and weight4 are equals : " + weight3.equals(weight4));

        Weight weight5 = new Weight(1_000_000.0, WeightUnit.GRAM);
        Weight weight6 = new Weight(1.0, WeightUnit.TONNE);
        System.out.println("are weight5 and weight6 are equals : " + weight5.equals(weight6));

        Weight weight7 = new Weight(0.001, WeightUnit.GRAM);
        Weight weight8 = new Weight(1.0, WeightUnit.MILLIGRAM);
        System.out.println("are weight7 and weight8 are equals : " + weight7.equals(weight8));

        System.out.println("weight converter :" + weight3.weightUnit.convertFromBaseUnit(weight3.value));

        System.out.println("addition of 2...................... weight units : " + weight1.add(weight2).toString()); // return weight1's  weightunit

        //  Weight weight1 = new Weight(1.0, WeightUnit.KILOGRAM);
        //  Weight weight3 = new Weight(453.59237, WeightUnit.GRAM);
        System.out.println("addition of 2 weight units with conversion into target : "
                + weight1.addAndConvert(weight3, WeightUnit.POUND).toString());

        System.out.println("convertToBaseUnit : " + WeightUnit.KILOGRAM.convertToBaseUnit(3.0));

        System.out.println("convertFromBaseUnit : " + WeightUnit.MILLIGRAM.convertFromBaseUnit(1.0));
    }

}
