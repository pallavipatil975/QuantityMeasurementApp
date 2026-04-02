package main.java.com.apps.quantitymeasurement.repository;

import main.java.com.apps.quantitymeasurement.model.QuantityMeasurementEntity;

import java.util.List;

public interface IQuantityMeasurementRepository {
    void save(QuantityMeasurementEntity entry);
    List<QuantityMeasurementEntity> getAllMeasurements();
}
