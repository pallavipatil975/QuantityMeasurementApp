package test.java.com.apps.quantitymeasurement;

import main.java.com.apps.quantitymeasurement.*;
import main.java.com.apps.quantitymeasurement.QuantityMeasurementApp.*;
import main.java.com.apps.quantitymeasurement.constant.LengthUnit;
import main.java.com.apps.quantitymeasurement.constant.WeightUnit;
import main.java.com.apps.quantitymeasurement.service.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.lang.reflect.WildcardType;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // test cases for feet class
    @Test
    public void testFeetEquality_SameValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);
        assertEquals(f1, f2);
    }

    @Test
    public void testFeetEquality_dfferentValue() {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(2.0);
        assertNotEquals(f1, f2);
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet f1 = new Feet(1.0);
        assertNotEquals(f1, null);
    }

    @Test
    public void testFeetEquality_differentClass() {
        Feet f1 = new Feet(1.0);
        //FeetDemo f2 = new FeetDemo();
        //  assertNotEquals(f1, f2);
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet f1 = new Feet(1.0);
        assertEquals(f1, f1);
    }

    // test cases for inches class
    @Test
    public void testInchesEquality_SameValue() {
        Inches f1 = new Inches(12.0);
        Inches f2 = new Inches(12.0);
        assertEquals(f1, f2);
    }

    @Test
    public void testInchesEquality_dfferentValue() {
        Inches f1 = new Inches(12.0);
        Inches f2 = new Inches(15.0);
        assertNotEquals(f1, f2);
    }

    @Test
    public void testInchesEquality_NullComparison() {
        Inches f1 = new Inches(12.0);
        assertNotEquals(f1, null);
    }

    @Test
    public void testInchesEquality_differentClass() {
        Inches f1 = new Inches(12.0);
        Feet f2 = new Feet(1.0);
        assertNotEquals(f1, f2);
    }

    @Test
    public void testInchesEquality_SameReference() {
        Inches f1 = new Inches(12.0);
        assertEquals(f1, f1);
    }

    @Test
    public void TestFeetEquality() {
        Quantity<LengthUnit> feet1 = new Quantity<LengthUnit>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> feet2 = new Quantity<LengthUnit>(1.0, LengthUnit.FEET);
        assertEquals(feet1, feet2);
    }

    @Test
    public void testInchesEquality() {
        Quantity<LengthUnit> inches1 = new Quantity<LengthUnit>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> inches2 = new Quantity<LengthUnit>(12.0, LengthUnit.INCHES);
        assertEquals(inches1, inches2);
    }

    @Test
    public void testFeetInchesComparison() {
        Quantity<LengthUnit> inches1 = new Quantity<LengthUnit>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> feet1 = new Quantity<LengthUnit>(1.0, LengthUnit.FEET);
        assertEquals(inches1, feet1);
    }

    @Test
    public void testFeetInequality() {
        Quantity<LengthUnit> feet1 = new Quantity<LengthUnit>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> feet2 = new Quantity<LengthUnit>(2.0, LengthUnit.FEET);
        assertNotEquals(feet1, feet2);
    }

    @Test
    public void testInchesInequality() {
        Quantity<LengthUnit> inches1 = new Quantity<LengthUnit>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> inches2 = new Quantity<LengthUnit>(24.0, LengthUnit.INCHES);
        assertNotEquals(inches1, inches2);
    }

    @Test
    public void testCrossUnitInequality() {
        Quantity<LengthUnit> inches1 = new Quantity<LengthUnit>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> feet1 = new Quantity<LengthUnit>(2.0, LengthUnit.FEET);
        assertNotEquals(inches1, feet1);
    }

    @Test
    public void testMultipleFeetComparison() {
        Quantity<LengthUnit> inches1 = new Quantity<LengthUnit>(3.0, LengthUnit.FEET);
        Quantity<LengthUnit> feet1 = new Quantity<LengthUnit>(3.0, LengthUnit.FEET);
        assertEquals(inches1, feet1);
    }

    @Test
    public void yardEquals36Inches() {
        Quantity<LengthUnit> yard = new Quantity<LengthUnit>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> inches = new Quantity<LengthUnit>(36.0, LengthUnit.INCHES);
        assertEquals(yard, inches);
    }

    @Test
    public void centimeterEquals39Points3701Inches() {
        Quantity<LengthUnit> centimeter = new Quantity<LengthUnit>(100.0, LengthUnit.CENTIMETER);
        Quantity<LengthUnit> inches = new Quantity<LengthUnit>(39.3701, LengthUnit.INCHES);
        assertEquals(centimeter, inches);
    }

    @Test
    public void threeFeetEqualsOneYard() {
        Quantity<LengthUnit> feet = new Quantity<LengthUnit>(3.0, LengthUnit.FEET);
        Quantity<LengthUnit> yard = new Quantity<LengthUnit>(1.0, LengthUnit.YARDS);
        assertEquals(feet, yard);
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        Quantity<LengthUnit> centimeter = new Quantity<LengthUnit>(30.48, LengthUnit.CENTIMETER);
        Quantity<LengthUnit> feet = new Quantity<LengthUnit>(1.0, LengthUnit.FEET);
        assertEquals(centimeter, feet);
    }

    @Test
    public void yardNotEqualsToInches() {
        Quantity<LengthUnit> yard = new Quantity<LengthUnit>(1.0, LengthUnit.YARDS);
        Quantity<LengthUnit> Inches = new Quantity<LengthUnit>(12.0, LengthUnit.INCHES);
        assertNotEquals(yard, Inches);
    }

    @ParameterizedTest
    @EnumSource(LengthUnit.class)
    public void referenceEqualitySameObject(LengthUnit unit) {
        Quantity<LengthUnit> length = new Quantity<LengthUnit>(1.0, unit);
        assertEquals(length, length);
    }

    @ParameterizedTest
    @EnumSource(LengthUnit.class)
    public void equalsReturnFalseForNull(LengthUnit unit) {
        Quantity<LengthUnit> length = new Quantity<LengthUnit>(1.0, unit);
    }


    @ParameterizedTest
    @EnumSource(LengthUnit.class)
    public void differentValueSSameUnitNotEqual(LengthUnit unit) {
        Quantity<LengthUnit> length1 = new Quantity<LengthUnit>(1.0, unit);
        Quantity<LengthUnit> length2 = new Quantity<LengthUnit>(12.0, unit);
        assertNotEquals(length1, length2);
    }

    @Test
    public void crossUnitEqualityDemonstrateMethod() {
        assertAll(
                () -> assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES)),
                () -> assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES)),
                () -> assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(100.0, LengthUnit.CENTIMETER, 39.3701, LengthUnit.INCHES)),
                () -> assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(3.0, LengthUnit.FEET, 1.0, LengthUnit.YARDS)),
                () -> assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(1.0, LengthUnit.YARDS, 91.44, LengthUnit.CENTIMETER)),
                () -> assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(30.48, LengthUnit.CENTIMETER, 1.0, LengthUnit.FEET))

        );
    }

    @Test
    public void reflexiveSymmetricAndTranstiveProperty() {
        Quantity<LengthUnit> l1 = new Quantity<LengthUnit>(0.3333, LengthUnit.YARDS);
        Quantity<LengthUnit> l2 = new Quantity<LengthUnit>(12.0, LengthUnit.INCHES);
        Quantity<LengthUnit> l3 = new Quantity<LengthUnit>(30.48, LengthUnit.CENTIMETER);
        Quantity<LengthUnit> l4 = new Quantity<LengthUnit>(1.0, LengthUnit.FEET);

        // reflexive
        assertEquals(l1, l2);

        //Symmetric
        assertEquals(l1, l2);
        assertEquals(l2, l1);
        assertEquals(l3, l4);
        assertEquals(l3, l4);
        assertEquals(l1, l3);

        //Transitive
        assertEquals(l1, l2);
        assertEquals(l2, l3);
        assertEquals(l1, l3);
        assertEquals(l3, l4);
        assertEquals(l4, l3);
    }

    @Test
    public void convertFeetToInches() {
        Quantity<LengthUnit> lengthInInches = QuantityMeasurementApp.demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        Quantity<LengthUnit> expectedLength = new Quantity<LengthUnit>(12.0, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches, expectedLength));
    }

    @Test
    public void convertYardToInchesUsingOverloadedMethod() {
        Quantity<LengthUnit> lengthInYards = new Quantity<LengthUnit>(2.0, LengthUnit.YARDS);
        Quantity<LengthUnit> lengthInInches = QuantityMeasurementApp.demonstrateLengthConversion(lengthInYards, LengthUnit.INCHES);
        Quantity<LengthUnit> expectedLength = new Quantity<LengthUnit>(72.0, LengthUnit.INCHES);

        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches, expectedLength));
    }

    @Test
    public void addFeetAndInches() {
        Quantity<LengthUnit> length1 = new Quantity<LengthUnit>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<LengthUnit>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> sumLength = QuantityMeasurementApp.demonstrateLengthAddition(length1, length2);
        Quantity<LengthUnit> expectedLength = new Quantity<LengthUnit>(2.0, LengthUnit.FEET);

        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sumLength, expectedLength));
    }

    @Test
    public void addFeetAndInchesWithTargetUnitInches() {
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> sumLength = QuantityMeasurementApp.demonstrateLengthAddition(length1, length2, LengthUnit.INCHES);

        Quantity<LengthUnit> expectedLength = new Quantity<>(24.0, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sumLength, expectedLength));
    }

    // WeightUnit test cases

    @Test
    public void testEquality_KilogramToKilogram_SameValue() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1000.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(1000.0, WeightUnit.KILOGRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_KilogramToKilogram_DifferentValue() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1000.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(2000.0, WeightUnit.KILOGRAM);
        assertNotEquals(w1, w2);
    }

    @Test
    public void testEquality_KilogramToGram_EquivalentValue() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(1000.0, WeightUnit.GRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_GramToKilogram_EquivalentValue() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(1.0, WeightUnit.KILOGRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_WeightVsLength_Incompatible() {
        Quantity<WeightUnit> weight = new Quantity<WeightUnit>(1.0, WeightUnit.KILOGRAM);
        Quantity<LengthUnit> length = new Quantity<LengthUnit>(1.0, LengthUnit.FEET);

        // Using assertNotEquals is sufficient
        assertNotEquals(weight, length);

        // If you want to be extra explicit:
        assertFalse(weight.equals(length));  // Quantity<WeightUnit>.equals(Quantity<LengthUnit>) -> false
        assertFalse(length.equals(weight));  // Quantity<LengthUnit>.equals(Quantity<WeightUnit>) -> false (assuming Quantity<LengthUnit> has the same guard)
    }


    @Test
    public void testEquality_NullComparison() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1000.0, WeightUnit.GRAM);
        assertNotEquals(w1, null);
    }

    @Test
    public void testEquality_SameReference() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1000.0, WeightUnit.GRAM);
        assertEquals(w1, w1);
    }

   @Test
    public void testEquality_nullUnit() {
       Assert.assertThrows(IllegalArgumentException.class , ()->
         new Quantity<WeightUnit>(1000.0, null));
    }



    @Test
    public void testEquality_TransitiveProperty() {

        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w3 = new Quantity<WeightUnit>(1000000.0, WeightUnit.MILLIGRAM);
        Quantity<WeightUnit> w4 = new Quantity<WeightUnit>(2.20462, WeightUnit.POUND);
        Quantity<WeightUnit> w5 = new Quantity<WeightUnit>(0.001, WeightUnit.TONNE);

        assertEquals(w1, w2);
        assertEquals(w2, w3);
        assertEquals(w1, w3);

        assertEquals(w1, w4);
        assertEquals(w2, w5);
        assertEquals(w1, w5);
    }

    @Test
    public void testEquality_ZeroValue() {

        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(0.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(0.0, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_NegativeWeight() {

        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(-1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(-1000.0, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_LargeWeightValue() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1000000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(1000.0, WeightUnit.KILOGRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_smallWeightValue() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(0.001, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(1.0, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void testConversion_KilogramToPound() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(2.20462, WeightUnit.POUND);
        Quantity<WeightUnit> weightInPound = QuantityMeasurementApp.demonstrateWeightConversion(w1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> expectedWeight = new Quantity<WeightUnit>(1.0, WeightUnit.KILOGRAM);

        assertEquals(weightInPound, expectedWeight);
    }

    @Test
    public void testConversion_sameUnit() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(3.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInPound = QuantityMeasurementApp.demonstrateWeightConversion(w1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> expectedWeight = new Quantity<WeightUnit>(3.0, WeightUnit.KILOGRAM);

        assertEquals(weightInPound, expectedWeight);
    }

    @Test
    public void testConversion_ZeroValue() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(0.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInPound = QuantityMeasurementApp.demonstrateWeightConversion(w1, WeightUnit.GRAM);
        Quantity<WeightUnit> expectedWeight = new Quantity<WeightUnit>(0.0, WeightUnit.GRAM);

        assertEquals(weightInPound, expectedWeight);
    }

    @Test
    public void testConversion_NegativeValue() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(-1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInPound = QuantityMeasurementApp.demonstrateWeightConversion(w1, WeightUnit.GRAM);
        Quantity<WeightUnit> expectedWeight = new Quantity<WeightUnit>(-1000.0, WeightUnit.GRAM);

        assertEquals(weightInPound, expectedWeight);
    }

    @Test
    public void testConversion_roundTrip() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(0.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInGram = QuantityMeasurementApp.demonstrateWeightConversion(w1, WeightUnit.GRAM);
        Quantity<WeightUnit> weightInPound = QuantityMeasurementApp.demonstrateWeightConversion(w1, WeightUnit.KILOGRAM);
        assertEquals(weightInPound, weightInGram);
    }

    @Test
    public void testAddition_SameUnit_KilogramPlusKilogram() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> addition = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> expectedAddition = new Quantity<WeightUnit>(2.0, WeightUnit.KILOGRAM);
        assertTrue(QuantityMeasurementApp.demonstrateWeightEquality(addition, expectedAddition));

    }

    @Test
    public void testAddition_CrossUnit_KilogramPlusGram() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> addition = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> expectedAddition = new Quantity<WeightUnit>(2.0, WeightUnit.KILOGRAM);
        assertTrue(QuantityMeasurementApp.demonstrateWeightEquality(addition, expectedAddition));
    }

    @Test
    public void testAddition_CrossUnit_PoundPlusKilogram() {

        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(2.20462, WeightUnit.POUND);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> addition = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> expectedAddition = new Quantity<WeightUnit>(2.0, WeightUnit.KILOGRAM);
        assertTrue(QuantityMeasurementApp.demonstrateWeightEquality(addition, expectedAddition));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Kilogram() {

        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> addition = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2, WeightUnit.GRAM);
        Quantity<WeightUnit> expectedAddition = new Quantity<WeightUnit>(2000.0, WeightUnit.GRAM);
    }

    @Test
    public void testAddition_Commutativity() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> addition = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2, WeightUnit.GRAM);
        Quantity<WeightUnit> addition1 = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2, WeightUnit.KILOGRAM);
        assertEquals(addition1, addition);

    }

    @Test
    public void testAddition_WithZero() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(5.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(0.0, WeightUnit.GRAM);
        Quantity<WeightUnit> addition = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2, WeightUnit.KILOGRAM);
        assertEquals(addition, w1);

    }

    @Test
    public void testAddition_NegativeValues() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(5.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(-2000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> addition = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> expectedAddition = new Quantity<WeightUnit>(3000.0, WeightUnit.GRAM);
        assertEquals(addition, expectedAddition);
    }

    @Test
    public void testAddition_LargeValues() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1e6, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(1e6, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> addition = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> expectedAddition = new Quantity<WeightUnit>(2e6, WeightUnit.KILOGRAM);
        assertEquals(addition, expectedAddition);
    }

    @Test
    public void testEquality_gramToGram_SameValue() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1.0, WeightUnit.GRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(1.0, WeightUnit.GRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_poundToPound_SameValue() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(453.59237, WeightUnit.POUND);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(453.59237, WeightUnit.POUND);
        assertEquals(w1, w2);
    }

    @Test
    public void kilogramEquals1000Grams() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(1000.0, WeightUnit.GRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void poundEquals453Point592Grams() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1.0, WeightUnit.POUND);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(453.5923, WeightUnit.GRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void tonneEquals1000000Grams() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1.0, WeightUnit.TONNE);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(1000000.0, WeightUnit.GRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void kilogramsNotEqualToPound() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(1000.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(453.592, WeightUnit.POUND);
        assertNotEquals(w1, w2);
    }

    @Test
    public void additionOfWeightsEqualsExpected() {
        Quantity<WeightUnit> w1 = new Quantity<WeightUnit>(500.0, WeightUnit.GRAM);
        Quantity<WeightUnit> w2 = new Quantity<WeightUnit>(500.0, WeightUnit.GRAM);

        Quantity<WeightUnit> sumWeight = QuantityMeasurementApp.demonstrateWeightAddition(w1, w2);
        Quantity<WeightUnit> expectedWeight = new Quantity<WeightUnit>(1000.0, WeightUnit.GRAM);

        System.out.println("additionOfWeightsEqualsExpected : sumWeight" + sumWeight);
        System.out.println("additionOfWeightsEqualsExpected : expectedWeight" + expectedWeight);
        assertEquals(sumWeight, expectedWeight);
    }

}

