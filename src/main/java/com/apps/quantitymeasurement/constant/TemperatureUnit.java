package main.java.com.apps.quantitymeasurement.constant;

import main.java.com.apps.quantitymeasurement.service.Imeasurable;
import main.java.com.apps.quantitymeasurement.service.SupportsArithmetic;

import java.util.function.Function;

public enum TemperatureUnit implements Imeasurable {

    // Supply the "to-base" (→ Celsius) converter per constant to avoid
    // illegal forward reference of static fields in enum constructor.
    CELSIUS(v -> v),
    FAHRENHEIT(v -> (v - 32.0) * (5.0 / 9.0)),
    KELVIN(v -> v - 273.15);

    // Per-constant function to convert from this unit to base (Celsius)
    private final Function<Double, Double> toBase;

    // UC14: arithmetic not supported for temperatures
    private final SupportsArithmetic supportsArithmetic = () -> false;

    TemperatureUnit(Function<Double, Double> toBase) {
        this.toBase = toBase;
    }

    // ---- Imeasurable implementation ----

    @Override
    public String getUnitName() {
        return name();
    }

    /**
     * Temperature is non-linear ⇒ factor isn’t meaningful.
     * Return 1.0 to satisfy the interface contract.
     */
    @Override
    public double getConversionFactor() {
        return 1.0;
    }

    /**
     * Convert from this unit to the base (Celsius).
     */
    @Override
    public double convertToBaseUnit(double value) {
        return toBase.apply(value);
    }

    /**
     * Convert from base (Celsius) to this unit.
     */
    @Override
    public double convertFromBaseUnit(double valueInCelsius) {
        switch (this) {
            case CELSIUS:
                return valueInCelsius;
            case FAHRENHEIT:
                return (valueInCelsius * (9.0 / 5.0)) + 32.0;
            case KELVIN:
                return valueInCelsius + 273.15;
            default:
                throw new IllegalStateException("Unknown temperature unit: " + this);
        }
    }

    /**
     * UC14: arithmetic on absolute temperature values is not supported.
     */
    @Override
    public boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    /**
     * Always throws, because temperature does not support arithmetic ops in UC14.
     * The 'operation' string is passed through to produce a clear error message.
     */
    @Override
    public void validateOperationSupport(String operation) {
        if(!supportsArithmetic.isSupported() && !operation.equals("ADD") && !operation.equals("SUBTRACT")){
        throw new UnsupportedOperationException(
                "Operation " + operation + " is not supported for Temperature units.");
    }
}}