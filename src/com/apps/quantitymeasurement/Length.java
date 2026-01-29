package com.apps.quantitymeasurement;

public class Length {

    private double value;
    private LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0);

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

    // convert the length value to base unit(inches)
    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    //compare two length objects for equality based on their values in the base unit
    public boolean compare(Length thatLength) {
        return Double.
                compare(this.convertToBaseUnit(),
                        thatLength.convertToBaseUnit()) == 0;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        Length length = (Length) o;
        return compare(length);
    }

    public static void main(String[] args) {

        Length length1 = new Length(12.0, LengthUnit.FEET);
        Length length2 = new Length(144.0, LengthUnit.INCHES);
        System.out.println("Are length equal?" + length1.equals(length2));
    }
}
