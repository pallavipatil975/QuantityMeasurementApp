package main.java.com.apps.quantitymeasurement.service.serviceImpl;

import main.java.com.apps.quantitymeasurement.constants.ArithmeticOperation;
import main.java.com.apps.quantitymeasurement.constants.LengthUnit;
import main.java.com.apps.quantitymeasurement.constants.TemperatureUnit;
import main.java.com.apps.quantitymeasurement.model.QuantityDTO;
import main.java.com.apps.quantitymeasurement.model.QuantityMeasurementEntity;
import main.java.com.apps.quantitymeasurement.model.QuantityModel;
import main.java.com.apps.quantitymeasurement.repository.IQuantityMeasurementRepository;
import main.java.com.apps.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import main.java.com.apps.quantitymeasurement.service.IMeasurable;
import main.java.com.apps.quantitymeasurement.service.IQuantityMeasurementService;
import main.java.com.apps.quantitymeasurement.validation.ArithmeticOperationsValidation;

import java.util.Objects;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private final IQuantityMeasurementRepository repository ;
    private QuantityMeasurementEntity quantityMeasurementEntity;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ArithmeticHelper arithmeticHelper =new ArithmeticHelper();
    private final ArithmeticOperationsValidation arithmeticOperationsValidation= new ArithmeticOperationsValidation();

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    private enum Operation{
        COMPARISON, CONVERSION, ARITHMETIC;
    }

    /**
     * @param thisQuantityDTO
     * @param thatQuantityDTO
     * @return
     */
    @Override
    public boolean compare(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
        arithmeticOperationsValidation.isValid(objectMapper.getQuantityModel(thisQuantityDTO), objectMapper.getQuantityModel(thatQuantityDTO));
        //and save the result after operation
        System.out.print("Comparing \n"+thisQuantityDTO+" And "+thatQuantityDTO);
        boolean result = compare(objectMapper.getQuantityModel(thisQuantityDTO), objectMapper.getQuantityModel(thatQuantityDTO));
        //quantityMeasurementEntity = objectMapper.getQuantityMeasurementEntity(objectMapper.getQuantityModel(thisQuantityDTO), objectMapper.getQuantityModel(thatQuantityDTO), null, ArithmeticOperation.ADD);
        //repository.save(quantityMeasurementEntity);
        return result;
    }

    //@Override
    private <U extends IMeasurable> boolean compare(QuantityModel<U> thisQuantityModel, QuantityModel<U> thatQuantityModel) {
        //objects validate here
        return Double.doubleToLongBits(thisQuantityModel.getValue()) == Double.doubleToLongBits(thatQuantityModel.getValue())
                && Objects.equals(thisQuantityModel.getUnit(), thatQuantityModel.getUnit())
                && Objects.equals(thisQuantityModel.getMeasurementType(), thatQuantityModel.getMeasurementType());
    }

    /**
     * @param thisQuantityDTO
     * @param thatQuantityDTO
     * @return
     */
    @Override
    public QuantityDTO convert(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
        arithmeticOperationsValidation.isValid(objectMapper.getQuantityModel(thisQuantityDTO), objectMapper.getQuantityModel(thatQuantityDTO));
        QuantityModel<IMeasurable> resultObject = arithmeticHelper.convertIntoTarget(objectMapper.getQuantityModel(thisQuantityDTO), objectMapper.getQuantityModel(thatQuantityDTO));
        quantityMeasurementEntity = objectMapper.getQuantityMeasurementEntity(objectMapper.getQuantityModel(thisQuantityDTO), objectMapper.getQuantityModel(thatQuantityDTO), resultObject, ArithmeticOperation.MULTIPLY);//Conversion
        repository.save(quantityMeasurementEntity);
        return objectMapper.getQuantityDTO(resultObject);  //convertTo(thisQuantityDTO, thatQuantityDTO);
    }

    private <U extends IMeasurable> double convertTo(QuantityModel<U> thisQuantityModel, QuantityModel<U> thatQuantityModel) {
        //Add conversion logic here
        return 1.0;
    }

    private <U extends IMeasurable> double convertTemperatureUnit(TemperatureUnit thisUnit, TemperatureUnit targetUnit){
        //validate and add the temperature conversion logic
        return 1.0;
    }

    /**
     * @param thisQuantityDTO
     * @param thatQuantityDTO
     * @return
     */
    @Override
    public QuantityDTO add(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
        QuantityModel<IMeasurable> thisQuantityModel = objectMapper.getQuantityModel(thisQuantityDTO);
        QuantityModel<IMeasurable> thatQuantityModel = objectMapper.getQuantityModel(thatQuantityDTO);
        arithmeticOperationsValidation.isValid(thisQuantityModel, thatQuantityModel);

        //preProcess
        double result = arithmeticHelper.performArithmeticBaseOperation(thisQuantityModel,thatQuantityModel,ArithmeticOperation.ADD);
        //postProcess

        QuantityModel<IMeasurable> resultObject = new QuantityModel<>(result, thisQuantityModel.getUnit(), thisQuantityModel.getMeasurementType());
        double add = objectMapper.convertFromBase(resultObject);
        resultObject.setValue(add);
        quantityMeasurementEntity = objectMapper.getQuantityMeasurementEntity(thisQuantityModel, thatQuantityModel, resultObject, ArithmeticOperation.ADD);
        repository.save(quantityMeasurementEntity);
        System.out.println("Addition of "+thisQuantityDTO.getValue()+" + "+thatQuantityDTO.getValue()+" = " +resultObject);
        return objectMapper.getQuantityDTO(resultObject);
    }

    /**
     * @param thisQuantityDTO
     * @param thatQuantityDTO
     * @param targetUnitDTO
     * @return
     */
    @Override
    public QuantityDTO add(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO, QuantityDTO targetUnitDTO) {
        QuantityDTO addObject = add(thisQuantityDTO, thatQuantityDTO);
        addObject.setValue(objectMapper.convertToBase(objectMapper.getQuantityModel(addObject)));
        addObject.setUnit(targetUnitDTO.getUnit());
        addObject.setValue(addObject.getUnit().convertFromBaseUnit(addObject.getValue()));
        System.out.println("Addition of "+thisQuantityDTO.getValue()+" + "+thatQuantityDTO.getValue()+" = " +addObject);
        return addObject;
        //postProcess is pending
    }

    /**
     * @param thisQuantityDTO
     * @param thatQuantityDTO
     * @return
     */
    @Override
    public QuantityDTO subtract(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
        QuantityModel<IMeasurable> thisQuantityModel = objectMapper.getQuantityModel(thisQuantityDTO);
        QuantityModel<IMeasurable> thatQuantityModel = objectMapper.getQuantityModel(thatQuantityDTO);
        arithmeticOperationsValidation.isValid(thisQuantityModel, thatQuantityModel);
        //preProcess
        double result = arithmeticHelper.performArithmeticBaseOperation(thisQuantityModel,thatQuantityModel,ArithmeticOperation.SUBTRACT);
        //postProcess

        QuantityModel<IMeasurable> resultObject = new QuantityModel<>(result, thisQuantityModel.getUnit(), thisQuantityModel.getMeasurementType());
        double sub = objectMapper.convertFromBase(resultObject);
        resultObject.setValue(sub);
        quantityMeasurementEntity = objectMapper.getQuantityMeasurementEntity(thisQuantityModel, thatQuantityModel, resultObject, ArithmeticOperation.SUBTRACT);
        repository.save(quantityMeasurementEntity);
        System.out.println("Subtraction "+thisQuantityDTO.getValue()+" - "+thatQuantityDTO.getValue()+" = " +resultObject);
        return objectMapper.getQuantityDTO(resultObject);
    }

    /**
     * @param thisQuantityDTO
     * @param thatQuantityDTO
     * @param targetUnitDTO
     * @return
     */
    @Override
    public QuantityDTO subtract(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO, QuantityDTO targetUnitDTO) {
        QuantityDTO subObject = subtract(thisQuantityDTO, thatQuantityDTO);
        subObject.setValue(objectMapper.convertToBase(objectMapper.getQuantityModel(subObject)));
        subObject.setUnit(targetUnitDTO.getUnit());
        subObject.setValue(subObject.getUnit().convertFromBaseUnit(subObject.getValue()));
        System.out.println("Subtraction "+thisQuantityDTO.getValue()+" - "+thatQuantityDTO.getValue()+" = " +subObject);
        return subObject;
    }

    /**
     * @param thisQuantityDTO
     * @param thatQuantityDTO
     * @return
     */
    @Override
    public double divide(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
        QuantityModel<IMeasurable> thisQuantityModel = objectMapper.getQuantityModel(thisQuantityDTO);
        QuantityModel<IMeasurable> thatQuantityModel = objectMapper.getQuantityModel(thatQuantityDTO);
        arithmeticOperationsValidation.isValid(thisQuantityModel, thatQuantityModel);

        double div = arithmeticHelper.performArithmeticBaseOperation(thisQuantityModel,thatQuantityModel,ArithmeticOperation.DIVIDE);
        System.out.println("Division of "+thisQuantityDTO.getValue()+""+thatQuantityDTO.getValue() +"= "+div);

        return div;
    }

    private <U extends IMeasurable> void validateArithmeticOperands(){

    }

    // Arithmetic operation Enum

    private <U extends IMeasurable> double performArithmetic(QuantityModel<U> thatQuantity, U targetUnit, ArithmeticOperation operation){
        return 1.0;
    }

    public static void main(String[] args) {

        QuantityMeasurementServiceImpl srv= new QuantityMeasurementServiceImpl(QuantityMeasurementCacheRepository.getInstance());
        QuantityDTO a = new QuantityDTO(12.0, LengthUnit.FEET, "LengthUnit");
        QuantityDTO b = new QuantityDTO(3.0, LengthUnit.FEET, "LengthUnit");
        QuantityDTO x = new QuantityDTO(12.0, LengthUnit.FEET, "LengthUnit");
        QuantityDTO y = new QuantityDTO(5.0, LengthUnit.FEET, "LengthUnit");
        QuantityDTO trgUnit = new QuantityDTO(36.0,LengthUnit.INCHES,"LengthUnit");

        srv.add(a, b);
        srv.add(x, y, trgUnit);

        srv.subtract(a,b);
        srv.subtract(a,y, new QuantityDTO(0.0,LengthUnit.INCHES," "));

        System.out.println("\n Compared 2 object = "+srv.compare(a,b));
        System.out.println("\n 2 object are equals = "+ srv.objectMapper.getQuantityModel(trgUnit).equals(srv.objectMapper.getQuantityModel(b)));
        System.out.println("Division of "+x.getValue() + " / "+y.getValue()+" = "+srv.divide(x,y));
    }
}
