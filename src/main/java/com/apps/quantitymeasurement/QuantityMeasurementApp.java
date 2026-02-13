package main.java.com.apps.quantitymeasurement;

import main.java.com.apps.quantitymeasurement.constant.LengthUnit;
import main.java.com.apps.quantitymeasurement.service.Length;
import main.java.com.apps.quantitymeasurement.constant.LengthUnit.*;

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
        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.YARDS);


        demonstrateLengthComparison(12.0, LengthUnit.FEET, 1.0, LengthUnit.INCHES);

        demonstrateLengthComparison(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES);

        demonstrateLengthComparison(100.0, LengthUnit.CENTIMETER, 39.3701, LengthUnit.INCHES);

        demonstrateLengthComparison(1.0, LengthUnit.FEET, 0.3333, LengthUnit.YARDS);

        demonstrateLengthComparison(30.48, LengthUnit.CENTIMETER, 1.0, LengthUnit.FEET);
        demonstrateLengthAddition(new Length(1.0, LengthUnit.YARDS), new Length(12, LengthUnit.INCHES));
        demonstrateLengthAddition(new Length(1.0, LengthUnit.CENTIMETER),
                new Length(12, LengthUnit.INCHES),
                LengthUnit.YARDS);
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2, LengthUnit targetUnit) {
        Length result = length1.addAndConvert(length2, targetUnit);
        System.out.println("addition of two units and conversion : " + result);
        return result;
    }

    public static Length demonstrateLengthAddition(Length length, Length length1) {
        Length sumLength = length.add(length1);
        System.out.println("addition of two units" + sumLength.add(length1).toString());
        return sumLength;
    }

    public static Length demonstrateLengthConversion(double v, LengthUnit lengthUnit, LengthUnit lengthUnit1) {
        Length l1 = new Length(v, lengthUnit);
        Length l2 = demonstrateLengthConversion(l1, lengthUnit1);
        System.out.println(l2.toString());
        return l2;
    }

    public static Length demonstrateLengthConversion(Length l1, LengthUnit lengthUnit1) {
        return new Length(l1.lengthUnit.convertFromBaseUnit(l1.value, lengthUnit1), lengthUnit1);
    }

    public static boolean demonstrateLengthComparison(double v, LengthUnit lengthUnit, double v1, LengthUnit lengthUnit1) {
        boolean result = demonstrateLengthEquality(new Length(v, lengthUnit), new Length(v1, lengthUnit1));
        System.out.println(result);
        return result;
    }

    public static void demonstrateFeetInchesComparison() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);

        System.out.println("feet equals inches : " + demonstrateLengthEquality(feet, inches));
    }

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        boolean result = length1.equals(length2);
        return result;
    }


}