package main.java.com.apps.quantitymeasurement.constant;

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

    public double convertToBaseUnit(double value) {
        return Math.round(value * getConversionFactor() * 100.0) / 100.0;
    }


    public double convertFromBaseUnit(double value) {
        return Math.round(value / getConversionFactor() * 100.0) / 100.0;
    }
}

