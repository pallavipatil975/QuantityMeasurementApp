package main.java.com.apps.quantitymeasurement.service;

public interface IMeasurableUnit {
    public String getUnitName();
    public String getMeasurementType();
    public IMeasurableUnit getUnitInstance(String unitName);
}
