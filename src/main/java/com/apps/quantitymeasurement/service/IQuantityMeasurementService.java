package main.java.com.apps.quantitymeasurement.service;

import main.java.com.apps.quantitymeasurement.model.QuantityDTO;

public interface IQuantityMeasurementService {

    public boolean compare(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO);
    public QuantityDTO convert(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO);
    public QuantityDTO add(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO);
    public QuantityDTO add(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO,QuantityDTO targetUnitDTO);
    public QuantityDTO subtract(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO);
    public QuantityDTO subtract(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO,QuantityDTO targetUnitDTO);
    public double divide(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO);
}
