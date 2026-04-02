package main.java.com.apps.quantitymeasurement.service;

public interface IMeasurable extends SupportsArithmetic,IMeasurableUnit {
    SupportsArithmetic supportsArithmetic = () -> true;
    public double getConversionFactor();
    public double convertToBaseUnit(double value);
    public double convertFromBaseUnit(double value);
    public String getUnitName();

    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    default void validateOperationSupport(String operation) {
        // Impl class can override this to validate specific operations
    }
}
