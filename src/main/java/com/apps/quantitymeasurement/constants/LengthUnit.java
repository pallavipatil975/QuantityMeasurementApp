package main.java.com.apps.quantitymeasurement.constants;

import main.java.com.apps.quantitymeasurement.service.IMeasurable;
import main.java.com.apps.quantitymeasurement.service.IMeasurableUnit;
import main.java.com.apps.quantitymeasurement.service.SupportsArithmetic;

public enum LengthUnit implements IMeasurable {
    FEET(12.0),
    INCHES(1.0),
    YARD(36.0),
    CENTIMETER(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
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

    /**
     * @param unitName
     * @return
     */
    @Override
    public IMeasurableUnit getUnitInstance(String unitName) {
        return null;
    }

    @Override
    public boolean isSupported() {
        return true;
    }
}
