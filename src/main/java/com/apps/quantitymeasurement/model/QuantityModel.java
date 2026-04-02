package main.java.com.apps.quantitymeasurement.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import main.java.com.apps.quantitymeasurement.service.IMeasurable;

import java.util.Objects;

@Data
@Getter
@Setter
public class QuantityModel<U extends IMeasurable> {
    private double value;
    private U unit;
    private String measurementType;

    public QuantityModel(double value, U unit, String measurementType) {
        this.value = value;
        this.unit =  unit;
        this.measurementType = measurementType;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityModel<?> that)) return false;

        if (!Objects.equals(this.getMeasurementType(), that.getMeasurementType())) {
            return false;
        }
        double thisBase = this.unit.convertToBaseUnit(this.value);
        double thatBase = that.unit.convertToBaseUnit(that.value);

        return Double.compare(thisBase, thatBase)==0;
    }


    @Override
    public int hashCode() {
        double baseValue = unit.convertToBaseUnit(value);
        long bits = Double.doubleToLongBits(baseValue);
        return Objects.hash(unit, bits);
    }



   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuantityModel<?>)) return false;

        QuantityModel<?> other = (QuantityModel<?>) o;

    }*/
}
