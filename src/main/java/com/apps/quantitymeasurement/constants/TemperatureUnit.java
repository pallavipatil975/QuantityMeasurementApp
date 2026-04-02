package main.java.com.apps.quantitymeasurement.constants;

import main.java.com.apps.quantitymeasurement.service.IMeasurable;
import main.java.com.apps.quantitymeasurement.service.IMeasurableUnit;
import main.java.com.apps.quantitymeasurement.service.SupportsArithmetic;

import java.util.function.Function;

public enum TemperatureUnit implements IMeasurable {
    CELSIUS("celsius"),
    FAHRENHEIT("fahrenheit"),
    KELVIN("kelvin");

    final Function<Double, Double> FAHRENHEIT_TO_CELSIUS = (fahrenheit) -> (fahrenheit -32 ) * 5/9;
    final Function<Double, Double> CELSIUS_TO_CELSIUS = (celsius) -> celsius;
    final Function<Double, Double> KELVIN_TO_CELSIUS = kelvin -> kelvin - 273.15;

    final Function<Double, Double> conversionValue;

    TemperatureUnit(String isFahrenheit) {
        if (isFahrenheit.equals("fahrenheit")) {
            this.conversionValue = FAHRENHEIT_TO_CELSIUS;
        } else if (isFahrenheit.equals("kelvin")) {
            this.conversionValue = KELVIN_TO_CELSIUS;
        } else {
            this.conversionValue = CELSIUS_TO_CELSIUS;
        }
    }

    @Override
    public double getConversionFactor() {
        return 1.0;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return conversionValue.apply(value);
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return switch (this) {
            case FAHRENHEIT -> (baseValue * 9 / 5) + 32;
            case KELVIN -> baseValue + 273.15;
            default -> baseValue;
        };
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

    final SupportsArithmetic supportArithmetic = () -> false;

    @Override
    public boolean supportsArithmetic() {
        return supportArithmetic.isSupported();
    }

    @Override
    public void validateOperationSupport(String operation) {
        if(!supportArithmetic.isSupported() && !operation.equals("ADD") && !operation.equals("SUBTRACT")) {
            String message = this.name() + " Temperature does not support " + operation + " operations";
            System.out.println(message);
            throw new UnsupportedOperationException(message);
        }
    }

    @Override
    public boolean isSupported() {
        return false;
    }
}
