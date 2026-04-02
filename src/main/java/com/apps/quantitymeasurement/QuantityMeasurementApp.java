package main.java.com.apps.quantitymeasurement;

import main.java.com.apps.quantitymeasurement.constants.LengthUnit;
import main.java.com.apps.quantitymeasurement.controller.QuantityMeasurementController;
import main.java.com.apps.quantitymeasurement.model.QuantityDTO;
import main.java.com.apps.quantitymeasurement.repository.IQuantityMeasurementRepository;
import main.java.com.apps.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import main.java.com.apps.quantitymeasurement.service.serviceImpl.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    private static QuantityMeasurementApp instance;

    public static QuantityMeasurementController controller = new QuantityMeasurementController();

    public IQuantityMeasurementRepository repository;

    private QuantityMeasurementApp(){
        this.repository = QuantityMeasurementCacheRepository.getInstance();
        QuantityMeasurementServiceImpl service = new QuantityMeasurementServiceImpl(this.repository);
        this.controller = new QuantityMeasurementController(service);
    }

    public static QuantityMeasurementApp getInstance(){
        if(instance == null){
            instance = new QuantityMeasurementApp();
        }
        return instance;
    }

    public static void main(String[] args) {

        //UC15
        QuantityDTO a = new QuantityDTO(12.0, LengthUnit.YARD, "LengthUnit");
        QuantityDTO b = new QuantityDTO(3.0, LengthUnit.YARD, "LengthUnit");

        controller.performAddition(a,b);
        controller.performSubstraction(a,b);
        controller.performDivision(a,b);

        }
}
