package main.java.com.apps.quantitymeasurement.service.serviceImpl;

import main.java.com.apps.quantitymeasurement.constants.ArithmeticOperation;
import main.java.com.apps.quantitymeasurement.model.QuantityModel;
import main.java.com.apps.quantitymeasurement.service.IMeasurable;
import main.java.com.apps.quantitymeasurement.service.IMeasurableUnit;

public class ArithmeticHelper {
    private ObjectMapper objectMapper =new ObjectMapper();

    public double performArithmeticBaseOperation(QuantityModel<IMeasurable> thisQuantityModel, QuantityModel<IMeasurable> thatQuantityModel, ArithmeticOperation operation){
        //this.operation=operation;
        //this.isValid(that);
        return operation.compute(objectMapper.convertToBase(thisQuantityModel),objectMapper.convertToBase(thatQuantityModel));
    }


    public <U extends IMeasurable> QuantityModel<IMeasurable> convertIntoTarget(QuantityModel<IMeasurable> thisQuantityModel, QuantityModel<IMeasurable> thatQuantityModel) {
        double thisBase =objectMapper.convertToBase(thisQuantityModel);
        thatQuantityModel.setValue(thisBase);
        return new QuantityModel<>(objectMapper.convertFromBase(thatQuantityModel), thatQuantityModel.getUnit(), thatQuantityModel.getMeasurementType());
    }
}
