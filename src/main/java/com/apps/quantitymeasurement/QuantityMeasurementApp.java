package main.java.com.apps.quantitymeasurement;

import main.java.com.apps.quantitymeasurement.constant.LengthUnit;
import main.java.com.apps.quantitymeasurement.constant.VolumeUnit;
import main.java.com.apps.quantitymeasurement.constant.WeightUnit;
import main.java.com.apps.quantitymeasurement.service.*;

public class QuantityMeasurementApp {

    public static class Inches {

        private final double inch;

        public Inches(double inch) {
            this.inch = inch;
        }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (!(obj instanceof Inches)) return false;
            Inches other = (Inches) obj;
            return Double.compare(this.inch, other.inch) == 0;
        }
    }

    public static class Feet {

        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (!(obj instanceof Feet)) return false;
            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    public static void demonstrateFeetEquality() {
        Feet f1 = new Feet(1.2);
        Feet f2 = new Feet(1.3);
        Feet f3 = new Feet(1.2);

        //  FeetDemo fd = new FeetDemo();

        System.out.println(f1.equals(f3));
        System.out.println(f1.equals(f2));
        System.out.println(f3.equals(null));
        //  System.out.println(fd.equals(f1));
        System.out.println(f2.equals(f2));
        System.out.println(f3.equals(f3));
    }

    public static void demonstrateInchesEquality() {
        Inches f1 = new Inches(11.0);
        Inches f2 = new Inches(12.0);
        Inches f3 = new Inches(1.0);
        Feet f11 = new Feet(1.2);

        System.out.println(f1.equals(f3));
        System.out.println(f1.equals(f2));
        System.out.println(f3.equals(null));
        System.out.println(f11.equals(f1));
        System.out.println(f2.equals(f2));
        System.out.println(f3.equals(f3));
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();


        demonstrateConversion(1.0, LengthUnit.FEET, LengthUnit.YARDS);
        demonstrateComparison(12.0, LengthUnit.FEET, 1.0, LengthUnit.INCHES);
        demonstrateComparison(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES);
        demonstrateComparison(100.0, LengthUnit.CENTIMETER, 39.3701, LengthUnit.INCHES);
        demonstrateComparison(1.0, LengthUnit.FEET, 0.3333, LengthUnit.YARDS);
        demonstrateComparison(30.48, LengthUnit.CENTIMETER, 1.0, LengthUnit.FEET);
        demonstrateAddition(new Quantity<>(1.0, LengthUnit.YARDS), new Quantity<>(12, LengthUnit.INCHES));
        demonstrateAddition(new Quantity<>(1.0, LengthUnit.CENTIMETER),
                new Quantity<>(12, LengthUnit.INCHES),
                LengthUnit.YARDS);

        Quantity<WeightUnit> w1 = new Quantity<>(1000000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.KILOGRAM);
        demonstrateEquality(w1, w2);
        demonstrateComparison(1.0, WeightUnit.KILOGRAM, 1000.0, WeightUnit.GRAM);

        demonstrateConversion(1.0, WeightUnit.KILOGRAM, WeightUnit.POUND);
        demonstrateAddition(new Quantity<>(1.0, WeightUnit.GRAM), new Quantity<>(1000.0, WeightUnit.KILOGRAM));
        demonstrateAddition(new Quantity<>(1000.0, WeightUnit.KILOGRAM),
                new Quantity<>(0.001, WeightUnit.MILLIGRAM), WeightUnit.POUND);


        System.out.println();
        System.out.println("----------- volume unit operations -----------");
        System.out.println();

        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITER);


        System.out.println(" Volume equals volume: " + demonstrateEquality(v1, v2));
        System.out.println(" Liter to Milliliter conversion : " + demonstrateConversion(1.0, VolumeUnit.LITRE, VolumeUnit.MILLILITER));
        System.out.println(" Milliliter to gallon conversion : " + demonstrateConversion(1000.0, VolumeUnit.MILLILITER, VolumeUnit.GALLON));
        System.out.println("Liter and Milliliter addition : " + demonstrateAddition(new Quantity<>(1.0, VolumeUnit.LITRE), new Quantity<>(1000.0, VolumeUnit.MILLILITER)));
        System.out.println("Liter and Milliliter comparison : " + demonstrateComparison(1.0, VolumeUnit.LITRE, 1000.0, VolumeUnit.MILLILITER));
        System.out.println("Milliliter and liter addition to liter : " + demonstrateAddition(new Quantity<>(1000.0, VolumeUnit.MILLILITER),
                new Quantity<>(1.0, VolumeUnit.LITRE), VolumeUnit.LITRE));
    }

    public static void demonstrateFeetInchesComparison() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("feet equals inches : " + demonstrateEquality(feet, inches));
    }
// Generic methods
    public static <U extends Imeasurable> boolean demonstrateEquality(Quantity<U> w1, Quantity<U> w2) {
        return w1.equals(w2);
    }

    public static <U extends Imeasurable> boolean demonstrateComparison(double v1, U fromUnit, double v2, U targetUnit) {
        Quantity<U> q1 = new Quantity<>(v1, fromUnit);
        Quantity<U> q2 = new  Quantity<>(v2, targetUnit);
        return q1.equals(q2);
    }

    public static<U extends Imeasurable> Quantity<U> demonstrateConversion(double v, U fromUnit, U targetUnit) {
       Quantity<U> q1 = demonstrateConversion(new Quantity<>(v, fromUnit), targetUnit);
       return q1;
    }

    public static <U extends Imeasurable> Quantity<U> demonstrateConversion(Quantity<U> w1, U weightUnit) {
        return new Quantity<>(weightUnit.convertFromBaseUnit(w1.getUnit().convertToBaseUnit(w1.getValue())), weightUnit);
    }

    public static <U extends Imeasurable> Quantity<U> demonstrateAddition(Quantity<U> q1, Quantity<U> q2) {
        return q1.add(q2);
    }

    public static <U extends Imeasurable> Quantity<U> demonstrateAddition(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        return q1.add(q2, targetUnit);
    }
}