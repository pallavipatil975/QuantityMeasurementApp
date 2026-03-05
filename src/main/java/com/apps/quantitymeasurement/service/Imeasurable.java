package main.java.com.apps.quantitymeasurement.service;

public interface Imeasurable {

    SupportsArithmetic supportsArithmetic = () -> true;

    public double getConversionFactor();
    public double convertToBaseUnit(double value);
    public double convertFromBaseUnit(double value);
    public String getUnitName();

    default boolean supportsArithmetic(){
        return true;
    }

    // throw UnsupportedOperationException if the nit does not support the
    // requested operation
    default void validateOperationSupport(String operation){
        // Subclasses can override to validate specific operations
    }

}
