package main.java.com.apps.quantitymeasurement.service;

public class Quantity<U extends Imeasurable> {
    private double value;
    private U unit;

    public Quantity(double value, U unit) {
        if(unit ==  null){
            throw new IllegalArgumentException("weightUnit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public <U extends Imeasurable> double convertTo(U targetUnit){
        return targetUnit.convertFromBaseUnit(this.getValue());
    }

    public Quantity<U> add(Quantity<U> other){

        if(other == null){
            throw new IllegalArgumentException("null is not allowed please enter valid Unit");
        }
        double unit1 = this.getUnit().convertToBaseUnit(this.getValue());
        double unit2 = other.getUnit().convertToBaseUnit(other.getValue());
        double addU1U2 = unit1 + unit2;
        return new Quantity<>(this.getUnit().convertFromBaseUnit(addU1U2), this.getUnit());
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit){
        Quantity<U> q1 = this.add(other);
        return new Quantity<U>(targetUnit.convertFromBaseUnit(q1.getUnit().convertToBaseUnit(q1.getValue())),targetUnit);
    }

    public Quantity<U> addAndConvert(Quantity<U> value, U targetUnit){
        return this.add(value, targetUnit);
    }

    //compare two  objects
    public boolean compare(Quantity<U> unit){
        return Double
                .compare(this.getUnit().convertToBaseUnit(this.getValue()),
                        unit.getUnit().convertToBaseUnit(unit.getValue())) == 0;
    }

    @Override
    public String toString() {
        return "Length{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity<U> u = (Quantity<U>) o;
        return compare(u);
    }
}