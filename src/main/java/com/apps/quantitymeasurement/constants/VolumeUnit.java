package main.java.com.apps.quantitymeasurement.constants;

import main.java.com.apps.quantitymeasurement.service.IMeasurable;
import main.java.com.apps.quantitymeasurement.service.IMeasurableUnit;

public enum VolumeUnit implements IMeasurable {
    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    public double convertToBaseUnit(double value) {
        return Math.round((value * getConversionFactor()) * 100.0) / 100.0;
    }

    public double convertFromBaseUnit(double value) {
        return Math.round((value / getConversionFactor()) * 100.0) / 100.0;
    }

    @Override
    public String getUnitName() {
        return this.name();
    }

    @Override
    public String getMeasurementType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public IMeasurableUnit getUnitInstance(String unitName) {
        return null;
    }

    @Override
    public boolean isSupported() {
        return true;
    }
}
