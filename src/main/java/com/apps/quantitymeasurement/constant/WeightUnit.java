package main.java.com.apps.quantitymeasurement.constant;

public enum WeightUnit {

    MILLIGRAM(0.001),     // 1 mg = 0.001 g
    GRAM(1.0),            // base unit
    KILOGRAM(1000.0),     // 1 kg = 1000 g
    POUND(453.59237),     // 1 lb = 453.59237 g  (more precise)
    TONNE(1_000_000.0);   // 1 t = 1,000,000 g


    private final double conversionFactor;


    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    // baseunit = 1.0 gram
    public double convertToBaseUnit(double value) {
        double gram = value * getConversionFactor();
        double result = Math.round(gram * 100.0) / 100.0;
       // System.out.println("result of conver to base unit is :" + result);
        return result;
    }

    public double convertFromBaseUnit(double value, WeightUnit targetUnit) {

        double gram = value * this.getConversionFactor(); // 1000(kg) * 1gm = 1000 gm
        double convertedFromBaseUnit = gram / targetUnit.getConversionFactor(); // first convert to base unit and then convert// 1000 / 453.592 (pound) =
        return Math.round(convertedFromBaseUnit * 100.0) / 100.0;
    }

}
