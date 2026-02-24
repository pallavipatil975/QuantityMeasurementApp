package main.java.com.apps.quantitymeasurement.service;

public interface Imeasurable {

    public double getConversionFactor();
    public double convertToBaseUnit(double value);
    public double convertFromBaseUnit(double value);
    public String getUnitName();

}
