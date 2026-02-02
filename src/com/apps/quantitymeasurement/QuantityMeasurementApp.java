package com.apps.quantitymeasurement;

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
    }

    private static void demonstrateFeetInchesComparison() {
       Length feet = new Length(1.0, Length.LengthUnit.FEET);
       Length inches = new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println("feet equals inches : " + demonstrateLengthEquality(feet, inches));
    }

    private static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }
}
