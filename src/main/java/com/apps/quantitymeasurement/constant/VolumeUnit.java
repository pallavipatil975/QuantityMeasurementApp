package main.java.com.apps.quantitymeasurement.constant;

import main.java.com.apps.quantitymeasurement.service.Imeasurable;

public enum VolumeUnit implements Imeasurable {
    LITRE(1.0), // base unit
    MILLILITER(0.001),
    GALLON(3.78541);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    // Convert any unit to base (litre)
    public double convertToBaseUnit(double value) {
        return Math.round(value * getConversionFactor() * 10000.0000) / 10000.0000;
    }

    // Convert from litre(base unit) to this unit
    public double convertFromBaseUnit(double value) {
        return Math.round(value / getConversionFactor() * 10000.0000) / 10000.0000;
    }

    @Override
    public String getUnitName() {
        return this.name();
    }
}

