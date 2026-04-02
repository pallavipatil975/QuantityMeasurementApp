package main.java.com.apps.quantitymeasurement.controller;

import main.java.com.apps.quantitymeasurement.constants.LengthUnit;
import main.java.com.apps.quantitymeasurement.model.QuantityDTO;
import main.java.com.apps.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import main.java.com.apps.quantitymeasurement.service.IQuantityMeasurementService;
import main.java.com.apps.quantitymeasurement.service.serviceImpl.QuantityMeasurementServiceImpl;

public class QuantityMeasurementController {

    private IQuantityMeasurementService quantityMeasurementService = new QuantityMeasurementServiceImpl(QuantityMeasurementCacheRepository.getInstance());

    public QuantityMeasurementController(){}
    public QuantityMeasurementController(IQuantityMeasurementService quantityMeasurementService) {
        this.quantityMeasurementService = quantityMeasurementService;
    }

    public boolean performComparison(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO){
        return quantityMeasurementService.compare(thisQuantityDTO, thatQuantityDTO);
    }

    public QuantityDTO performConversion(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO){
        return quantityMeasurementService.convert(thisQuantityDTO, thatQuantityDTO);
    }

    public QuantityDTO performAddition(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO){
        return quantityMeasurementService.add(thisQuantityDTO, thatQuantityDTO);
    }

    public QuantityDTO performAddition(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO, QuantityDTO targetUnitDTO){
        return quantityMeasurementService.add(thisQuantityDTO, thatQuantityDTO, targetUnitDTO);
    }

    public QuantityDTO performSubstraction(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO){
        return quantityMeasurementService.subtract(thisQuantityDTO, thatQuantityDTO);
    }

    public QuantityDTO performSubstraction(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO, QuantityDTO targetUnitDTO){
        return quantityMeasurementService.subtract(thisQuantityDTO, thatQuantityDTO, targetUnitDTO);
    }

    public double performDivision(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO){
        return quantityMeasurementService.divide(thisQuantityDTO, thatQuantityDTO);
    }

    public static void main(String[] args) {

        QuantityMeasurementController ctrl = new QuantityMeasurementController();

        QuantityDTO a = new QuantityDTO(12.0, LengthUnit.YARD, "LengthUnit");
        QuantityDTO b = new QuantityDTO(3.0, LengthUnit.YARD, "LengthUnit");
        QuantityDTO x = new QuantityDTO(12.0, LengthUnit.YARD, "LengthUnit");
        QuantityDTO y = new QuantityDTO(5.0, LengthUnit.YARD, "LengthUnit");
        QuantityDTO trgUnit = new QuantityDTO(0.0, LengthUnit.FEET, " ");

        ctrl.performAddition(a,b);
        ctrl.performAddition(a,y,trgUnit);

        ctrl.performSubstraction(x,y);
        ctrl.performSubstraction(b,y, new QuantityDTO(0.0, LengthUnit.INCHES, " "));


        System.out.println("\n Compared 2 object = " + ctrl.performComparison(a, b));
        System.out.println("\n Compared 2 object = " + ctrl.performComparison(a, b));
        System.out.println("Division of " + x.getValue() + " / " + y.getValue() + " = " + ctrl.performDivision(x, y));
    }
}
