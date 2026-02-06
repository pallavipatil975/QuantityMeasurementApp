package main.java.com.apps.quantitymeasurement.constant;

public enum WeightUnit {
    //conversion fatctor to the base unit (grams)

    MILLIGRAM(0.001),
    GRAM(1.0),
    KILOGRAM(1000.0),
    POUND(453.592),
    TONNE(1_000_000.0);

    // conversion factor to the base unit (grams)
    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    public double convertFromBaseUnit(double baseValue){
        return Math.round((baseValue / this.conversionFactor) * 100.0) / 100.0;
    }
}

