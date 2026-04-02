package main.java.com.apps.quantitymeasurement.exception;

public class QuantityMeasurementException extends RuntimeException {
    public QuantityMeasurementException(String message) {
        super(message);
    }

    public QuantityMeasurementException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void main(String[] args) {
        throw new QuantityMeasurementException("testing exception");
    }
}
