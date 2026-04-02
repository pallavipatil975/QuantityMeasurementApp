package main.java.com.apps.quantitymeasurement.model;

import lombok.Data;
import main.java.com.apps.quantitymeasurement.service.IMeasurable;

import java.io.Serializable;
import java.util.Objects;

@Data
public class QuantityMeasurementEntity implements Serializable {
    private static final long serialVersionUID = 1l;
    public double thisValue;
    public String thisUnit;
    public String thisMeasurementType;
    public double thatValue;
    public String thatUnit;
    public String thatMeasurementType;

    public String operation;
    public double resultValue;
    public String resultUnit;
    public String resultMeasurementType;

    public String resultString;

    public boolean isError;

    public String errorMessage;


    public QuantityMeasurementEntity(QuantityModel<IMeasurable> thisQuantity, QuantityModel<IMeasurable> thatQuantity, String operation, String result){
        this(thisQuantity, thatQuantity, operation);
        this.resultString = result;
    }

    public QuantityMeasurementEntity(QuantityModel<IMeasurable> thisQuantity, QuantityModel<IMeasurable> thatQuantity, String operation, QuantityModel<IMeasurable> result){
        this(thisQuantity, thatQuantity, operation);
        this.resultValue = result.getValue();
        this.resultUnit = result.getUnit().getUnitName();
        this.resultMeasurementType = result.getUnit().getMeasurementType();
    }

    public QuantityMeasurementEntity(QuantityModel<IMeasurable> thisQuantity, QuantityModel<IMeasurable> thatQuantity, String operation, String errorMessage, boolean isError){
        this(thisQuantity, thatQuantity, operation);
        this.errorMessage = errorMessage;
        this.isError = isError;
    }

    public QuantityMeasurementEntity(QuantityModel<IMeasurable> thisQuantity, QuantityModel<IMeasurable>thatQuantity, String operation) {
        this.thisValue = thisQuantity.getValue();
        this.thisUnit = String.valueOf(thisQuantity.getUnit());
        this.thisMeasurementType = thisQuantity.getMeasurementType();
        this.thatValue = thatQuantity.getValue();
        this.thatUnit = String.valueOf(thatQuantity.getUnit());
        this.thatMeasurementType = thatQuantity.getMeasurementType();
        this.operation = operation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuantityMeasurementEntity other)) return false;

        return compare(other);
    }

    private boolean compare(QuantityMeasurementEntity other) {
        return Double.doubleToLongBits(this.thisValue) == Double.doubleToLongBits(other.thisValue)
                && Double.doubleToLongBits(this.thatValue) == Double.doubleToLongBits(other.thatValue)
                && Double.doubleToLongBits(this.resultValue) == Double.doubleToLongBits(other.resultValue)
                && this.isError == other.isError
                && Objects.equals(this.thisUnit, other.thisUnit)
                && Objects.equals(this.thisMeasurementType, other.thisMeasurementType)
                && Objects.equals(this.thatUnit, other.thatUnit)
                && Objects.equals(this.thatMeasurementType, other.thatMeasurementType)
                && Objects.equals(this.operation, other.operation)
                && Objects.equals(this.resultUnit, other.resultUnit)
                && Objects.equals(this.resultMeasurementType, other.resultMeasurementType)
                && Objects.equals(this.resultString, other.resultString)
                && Objects.equals(this.errorMessage, other.errorMessage);
    }


    @Override
    public int hashCode() {
        return Objects.hash(
                Double.doubleToLongBits(thisValue),
                thisUnit,
                thisMeasurementType,
                Double.doubleToLongBits(thatValue),
                thatUnit,
                thatMeasurementType,
                operation,
                Double.doubleToLongBits(resultValue),
                resultUnit,
                resultMeasurementType,
                resultString,
                isError,
                errorMessage
        );
    }


}