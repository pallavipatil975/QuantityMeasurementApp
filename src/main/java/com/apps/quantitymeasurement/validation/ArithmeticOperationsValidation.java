package main.java.com.apps.quantitymeasurement.validation;

import main.java.com.apps.quantitymeasurement.model.QuantityModel;
import main.java.com.apps.quantitymeasurement.service.IMeasurable;

public class ArithmeticOperationsValidation {

    public  <U extends IMeasurable> boolean isValid(QuantityModel<U> thisQuantityModel, QuantityModel<U> thatQuantityModel){

        if(thatQuantityModel == null)
            throw new IllegalArgumentException("null not allowed, Please enter values");
        else if (Double.isNaN(thisQuantityModel.getValue()) || Double.isInfinite(thisQuantityModel.getValue()) ||
                (Double.isNaN(thatQuantityModel.getValue()) || Double.isInfinite(thatQuantityModel.getValue())))
            throw new IllegalArgumentException("please Enter valid No.");
        else if (thisQuantityModel.getUnit().getClass() != thatQuantityModel.getUnit().getClass())
            throw new IllegalArgumentException("Please keep type safety");

        return true;
    }

    public <U extends IMeasurable> boolean isValid(QuantityModel<U> thisQuantityModel, QuantityModel<U> thatQuantityModel, U targetUnit) {
        isValid(thisQuantityModel,thatQuantityModel);
        if(targetUnit == null){
            throw new IllegalArgumentException("Null unit not allowed, please enter unit");
        } else if(thatQuantityModel.getUnit().getClass() != targetUnit.getClass() ){
            throw new IllegalArgumentException("Unit is not valid, Please keep type safety with target-unit");
        }
        return true;
    }
}
