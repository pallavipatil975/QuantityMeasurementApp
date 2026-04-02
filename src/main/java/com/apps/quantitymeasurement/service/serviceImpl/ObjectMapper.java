package main.java.com.apps.quantitymeasurement.service.serviceImpl;

import lombok.Data;
import main.java.com.apps.quantitymeasurement.constants.ArithmeticOperation;
import main.java.com.apps.quantitymeasurement.model.QuantityDTO;
import main.java.com.apps.quantitymeasurement.model.QuantityMeasurementEntity;
import main.java.com.apps.quantitymeasurement.model.QuantityModel;
import main.java.com.apps.quantitymeasurement.service.IMeasurable;

@Data
public class ObjectMapper {
    private QuantityModel<IMeasurable> quantityModel;
    private QuantityDTO quantityDTO;

    public QuantityModel<IMeasurable> getQuantityModel(QuantityDTO quantityDTO){
        return new QuantityModel<>(quantityDTO.getValue(), quantityDTO.getUnit(), quantityDTO.getMeasurementType());
    }

    public QuantityDTO getQuantityDTO(QuantityModel<IMeasurable> quantityModel){
        return new QuantityDTO(quantityModel.getValue(), quantityModel.getUnit(), quantityModel.getMeasurementType());
    }

    public <U extends IMeasurable> double convertFromBase(QuantityModel<IMeasurable> quantityModel){
        // isValid(this);
        return quantityModel.getUnit().convertFromBaseUnit(quantityModel.getValue());
    }

    public <U extends IMeasurable> double convertToBase(QuantityModel<IMeasurable> quantityModel){
        // isValid(this);
        return quantityModel.getUnit().convertToBaseUnit(quantityModel.getValue());
    }

    public QuantityMeasurementEntity getQuantityMeasurementEntity(QuantityModel<IMeasurable> thisQuantityModel, QuantityModel<IMeasurable> thatQuantityModel, QuantityModel<IMeasurable> resultObject, ArithmeticOperation arithmeticOperation) {

        return new QuantityMeasurementEntity(thisQuantityModel, thatQuantityModel, arithmeticOperation.getUnitName(), resultObject);
    }
}
