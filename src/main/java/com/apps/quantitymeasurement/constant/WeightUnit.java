package main.java.com.apps.quantitymeasurement.constant;

import main.java.com.apps.quantitymeasurement.service.Imeasurable;

public enum WeightUnit implements Imeasurable {

    MILLIGRAM(0.001),     // 1 mg = 0.001 g
    GRAM(1.0),            // base unit
    KILOGRAM(1000.0),     // 1 kg = 1000 g
    POUND(453.59237),     // 1 lb = 453.59237 g  (more precise)
    TONNE(1_000_000.0);   // 1 t = 1,000,000 g

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    // baseunit = 1.0 gram
    public double convertToBaseUnit(double value) {
        return Math.round(value * getConversionFactor() * 100.0) / 100.0;
    }

    public double convertFromBaseUnit(double value) {
        return Math.round(value / getConversionFactor() * 100.0) / 100.0;    }

    @Override
    public String getUnitName() {
        return this.name();
    }

}
