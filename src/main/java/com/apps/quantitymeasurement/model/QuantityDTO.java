package main.java.com.apps.quantitymeasurement.model;

import lombok.Data;
import lombok.Getter;
import main.java.com.apps.quantitymeasurement.service.IMeasurable;

@Data
@Getter
public class QuantityDTO {
   private double value;
   private IMeasurable unit;
   private String measurementType;

    public QuantityDTO(double value, IMeasurable unit) {
        this.value = value;
        this.unit = unit;
        this.measurementType = unit.getMeasurementType();
    }

    public QuantityDTO(double value, IMeasurable unit, String measurementType) {
        this.value = value;
        this.unit = unit;
        this.measurementType = measurementType;
    }
}
