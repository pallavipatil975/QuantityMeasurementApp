package main.java.com.apps.quantitymeasurement;

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
        demonstrateLengthConversion(1.0, Length.LengthUnit.FEET, Length.LengthUnit.YARDS);


        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET, 12.0, Length.LengthUnit.INCHES);

        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,36.0, Length.LengthUnit.INCHES);

        demonstrateLengthComparison(100.0, Length.LengthUnit.CENTIMETER, 39.3701, Length.LengthUnit.INCHES);

        demonstrateLengthComparison(3.0, Length.LengthUnit.FEET,1.0, Length.LengthUnit.YARDS);

        demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETER,1.0, Length.LengthUnit.FEET);
        demonstrateLengthAddition(new Length(1.0, Length.LengthUnit.YARDS), new Length(12, Length.LengthUnit.INCHES));
        demonstrateLengthAddition(new Length(1.0, Length.LengthUnit.CENTIMETER),
                                  new Length(12, Length.LengthUnit.INCHES),
                                  Length.LengthUnit.YARDS);
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2, Length.LengthUnit targetUnit) {
        Length result = length1.addAndConvert(length2, targetUnit);
        System.out.println("addition of two units and conversion : " + result);
        return result;
    }

    public static Length demonstrateLengthAddition(Length length, Length length1) {
        Length sumLengthlength = length.add(length1);
        System.out.println("addition of two units" + sumLengthlength.toString());
        return sumLengthlength;
    }


    public static Length demonstrateLengthConversion(double v, Length.LengthUnit lengthUnit, Length.LengthUnit lengthUnit1) {
        Length l1 = new Length(v,lengthUnit);
        Length l2 = demonstrateLengthConversion(l1, lengthUnit1);
        System.out.println(l2.toString());
        return l2;
    }

    public static Length demonstrateLengthConversion(Length l1, Length.LengthUnit lengthUnit1) {
        return l1.convertTo(lengthUnit1);
    }

    public static boolean demonstrateLengthComparison(double v, Length.LengthUnit lengthUnit, double v1, Length.LengthUnit lengthUnit1) {
       boolean result = demonstrateLengthEquality(new Length(v,lengthUnit), new Length(v1, lengthUnit1));
       System.out.println(result);
       return result;
    }

    public static void demonstrateFeetInchesComparison() {
        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println("feet equals inches : " + demonstrateLengthEquality(feet, inches));
    }

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        boolean result = length1.equals(length2);
        return result;
    }



}