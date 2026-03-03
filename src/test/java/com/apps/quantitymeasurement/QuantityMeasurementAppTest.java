package test.java.com.apps.quantitymeasurement;

import main.java.com.apps.quantitymeasurement.*;
import main.java.com.apps.quantitymeasurement.QuantityMeasurementApp.*;
import main.java.com.apps.quantitymeasurement.constant.LengthUnit;
import main.java.com.apps.quantitymeasurement.constant.VolumeUnit;
import main.java.com.apps.quantitymeasurement.constant.WeightUnit;
import main.java.com.apps.quantitymeasurement.service.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.lang.reflect.WildcardType;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double DELTA = 0.0000000;

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
        assertNotEquals(length, null);
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
                () -> assertTrue(QuantityMeasurementApp.demonstrateComparison(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES)),
                () -> assertTrue(QuantityMeasurementApp.demonstrateComparison(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES)),
                () -> assertTrue(QuantityMeasurementApp.demonstrateComparison(100.0, LengthUnit.CENTIMETER, 39.3701, LengthUnit.INCHES)),
                () -> assertTrue(QuantityMeasurementApp.demonstrateComparison(3.0, LengthUnit.FEET, 1.0, LengthUnit.YARDS)),
                () -> assertTrue(QuantityMeasurementApp.demonstrateComparison(1.0, LengthUnit.YARDS, 91.44, LengthUnit.CENTIMETER)),
                () -> assertTrue(QuantityMeasurementApp.demonstrateComparison(30.48, LengthUnit.CENTIMETER, 1.0, LengthUnit.FEET))

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
        Quantity<LengthUnit> lengthInInches = QuantityMeasurementApp.demonstrateConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        Quantity<LengthUnit> expectedLength = new Quantity<>(12.0, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateEquality(lengthInInches, expectedLength));
    }

    @Test
    public void convertYardToInchesUsingOverloadedMethod() {
        Quantity<LengthUnit> lengthInYards = new Quantity<>(2.0, LengthUnit.YARDS);
        Quantity<LengthUnit> lengthInInches = QuantityMeasurementApp.demonstrateConversion(lengthInYards, LengthUnit.INCHES);
        Quantity<LengthUnit> expectedLength = new Quantity<>(72.0, LengthUnit.INCHES);

        assertTrue(QuantityMeasurementApp.demonstrateEquality(lengthInInches, expectedLength));
    }

    @Test
    public void addFeetAndInches() {
        Quantity<LengthUnit> length1 = new Quantity<LengthUnit>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<LengthUnit>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> sumLength = QuantityMeasurementApp.demonstrateAddition(length1, length2);
        Quantity<LengthUnit> expectedLength = new Quantity<LengthUnit>(2.0, LengthUnit.FEET);

        assertTrue(QuantityMeasurementApp.demonstrateEquality(sumLength, expectedLength));
    }

    @Test
    public void addFeetAndInchesWithTargetUnitInches() {
        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> sumLength = QuantityMeasurementApp.demonstrateAddition(length1, length2, LengthUnit.INCHES);

        Quantity<LengthUnit> expectedLength = new Quantity<>(24.0, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateEquality(sumLength, expectedLength));
    }

    // WeightUnit test cases

    @Test
    public void testEquality_KilogramToKilogram_SameValue() {
        Quantity<WeightUnit> w1 = new Quantity<>(1000.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.KILOGRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_KilogramToKilogram_DifferentValue() {
        Quantity<WeightUnit> w1 = new Quantity<>(1000.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(2000.0, WeightUnit.KILOGRAM);
        assertNotEquals(w1, w2);
    }

    @Test
    public void testEquality_KilogramToGram_EquivalentValue() {
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_GramToKilogram_EquivalentValue() {
        Quantity<WeightUnit> w1 = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_WeightVsLength_Incompatible() {
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<LengthUnit> length = new Quantity<LengthUnit>(1.0, LengthUnit.FEET);

        assertNotEquals(weight, length);

        assertFalse(weight.equals(length));  // Quantity<WeightUnit>.equals(Quantity<LengthUnit>) -> false
        assertFalse(length.equals(weight));  // Quantity<LengthUnit>.equals(Quantity<WeightUnit>) -> false (assuming Quantity<LengthUnit> has the same guard)
    }


    @Test
    public void testEquality_NullComparison() {
        Quantity<WeightUnit> w1 = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertNotEquals(w1, null);
    }

    @Test
    public void testEquality_SameReference() {
        Quantity<WeightUnit> w1 = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertEquals(w1, w1);
    }

    @Test
    public void testEquality_nullUnit() {
        Assert.assertThrows(IllegalArgumentException.class, () ->
                new Quantity<WeightUnit>(1000.0, null));
    }

    @Test
    public void testEquality_TransitiveProperty() {

        Quantity<WeightUnit> w1 = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w3 = new Quantity<>(1000000.0, WeightUnit.MILLIGRAM);
        Quantity<WeightUnit> w4 = new Quantity<>(2.20462, WeightUnit.POUND);
        Quantity<WeightUnit> w5 = new Quantity<>(0.001, WeightUnit.TONNE);

        assertEquals(w1, w2);
        assertEquals(w2, w3);
        assertEquals(w1, w3);

        assertEquals(w1, w4);
        assertEquals(w2, w5);
        assertEquals(w1, w5);
    }

    @Test
    public void testEquality_ZeroValue() {

        Quantity<WeightUnit> w1 = new Quantity<>(0.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(0.0, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_NegativeWeight() {

        Quantity<WeightUnit> w1 = new Quantity<>(-1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(-1000.0, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_LargeWeightValue() {
        Quantity<WeightUnit> w1 = new Quantity<>(1000000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.KILOGRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_smallWeightValue() {
        Quantity<WeightUnit> w1 = new Quantity<>(0.001, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1.0, WeightUnit.GRAM);

        assertEquals(w1, w2);
    }

    @Test
    public void testConversion_KilogramToPound() {
        Quantity<WeightUnit> w1 = new Quantity<>(2.20462, WeightUnit.POUND);
        Quantity<WeightUnit> weightInPound = QuantityMeasurementApp.demonstrateConversion(w1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> expectedWeight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertEquals(weightInPound, expectedWeight);
    }

    @Test
    public void testConversion_sameUnit() {
        Quantity<WeightUnit> w1 = new Quantity<>(3.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInPound = QuantityMeasurementApp.demonstrateConversion(w1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> expectedWeight = new Quantity<>(3.0, WeightUnit.KILOGRAM);

        assertEquals(weightInPound, expectedWeight);
    }

    @Test
    public void testConversion_ZeroValue() {
        Quantity<WeightUnit> w1 = new Quantity<>(0.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInPound = QuantityMeasurementApp.demonstrateConversion(w1, WeightUnit.GRAM);
        Quantity<WeightUnit> expectedWeight = new Quantity<>(0.0, WeightUnit.GRAM);

        assertEquals(weightInPound, expectedWeight);
    }

    @Test
    public void testConversion_NegativeValue() {
        Quantity<WeightUnit> w1 = new Quantity<>(-1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInPound = QuantityMeasurementApp.demonstrateConversion(w1, WeightUnit.GRAM);
        Quantity<WeightUnit> expectedWeight = new Quantity<>(-1000.0, WeightUnit.GRAM);

        assertEquals(weightInPound, expectedWeight);
    }

    @Test
    public void testConversion_roundTrip() {
        Quantity<WeightUnit> w1 = new Quantity<>(0.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightInGram = QuantityMeasurementApp.demonstrateConversion(w1, WeightUnit.GRAM);
        Quantity<WeightUnit> weightInPound = QuantityMeasurementApp.demonstrateConversion(w1, WeightUnit.KILOGRAM);
        assertEquals(weightInPound, weightInGram);
    }

    @Test
    public void testAddition_SameUnit_KilogramPlusKilogram() {
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> addition = QuantityMeasurementApp.demonstrateAddition(w1, w2, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> expectedAddition = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        assertTrue(QuantityMeasurementApp.demonstrateEquality(addition, expectedAddition));

    }

    @Test
    public void testAddition_CrossUnit_KilogramPlusGram() {
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> addition = QuantityMeasurementApp.demonstrateAddition(w1, w2, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> expectedAddition = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        assertTrue(QuantityMeasurementApp.demonstrateEquality(addition, expectedAddition));
    }

    @Test
    public void testAddition_CrossUnit_PoundPlusKilogram() {

        Quantity<WeightUnit> w1 = new Quantity<>(2.20462, WeightUnit.POUND);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> addition = QuantityMeasurementApp.demonstrateAddition(w1, w2, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> expectedAddition = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        assertTrue(QuantityMeasurementApp.demonstrateEquality(addition, expectedAddition));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Kilogram() {

        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> addition = QuantityMeasurementApp.demonstrateAddition(w1, w2, WeightUnit.GRAM);
        Quantity<WeightUnit> expectedAddition = new Quantity<>(2000.0, WeightUnit.GRAM);
        assertEquals(addition, expectedAddition);
    }

    @Test
    public void testAddition_Commutativity() {
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> addition = QuantityMeasurementApp.demonstrateAddition(w1, w2, WeightUnit.GRAM);
        Quantity<WeightUnit> addition1 = QuantityMeasurementApp.demonstrateAddition(w1, w2, WeightUnit.KILOGRAM);
        assertEquals(addition1, addition);

    }

    @Test
    public void testAddition_WithZero() {
        Quantity<WeightUnit> w1 = new Quantity<>(5.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(0.0, WeightUnit.GRAM);
        Quantity<WeightUnit> addition = QuantityMeasurementApp.demonstrateAddition(w1, w2, WeightUnit.KILOGRAM);
        assertEquals(addition, w1);

    }

    @Test
    public void testAddition_NegativeValues() {
        Quantity<WeightUnit> w1 = new Quantity<>(5.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(-2000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> addition = QuantityMeasurementApp.demonstrateAddition(w1, w2, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> expectedAddition = new Quantity<>(3000.0, WeightUnit.GRAM);
        assertEquals(addition, expectedAddition);
    }

    @Test
    public void testAddition_LargeValues() {
        Quantity<WeightUnit> w1 = new Quantity<>(1e6, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1e6, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> addition = QuantityMeasurementApp.demonstrateAddition(w1, w2, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> expectedAddition = new Quantity<>(2e6, WeightUnit.KILOGRAM);
        assertEquals(addition, expectedAddition);
    }

    @Test
    public void testEquality_gramToGram_SameValue() {
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.GRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1.0, WeightUnit.GRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void testEquality_poundToPound_SameValue() {
        Quantity<WeightUnit> w1 = new Quantity<>(453.59237, WeightUnit.POUND);
        Quantity<WeightUnit> w2 = new Quantity<>(453.59237, WeightUnit.POUND);
        assertEquals(w1, w2);
    }

    @Test
    public void kilogramEquals1000Grams() {
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void poundEquals453Point592Grams() {
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.POUND);
        Quantity<WeightUnit> w2 = new Quantity<>(453.5923, WeightUnit.GRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void tonneEquals1000000Grams() {
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.TONNE);
        Quantity<WeightUnit> w2 = new Quantity<>(1000000.0, WeightUnit.GRAM);
        assertEquals(w1, w2);
    }

    @Test
    public void kilogramsNotEqualToPound() {
        Quantity<WeightUnit> w1 = new Quantity<>(1000.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(453.592, WeightUnit.POUND);
        assertNotEquals(w1, w2);
    }

    @Test
    public void additionOfWeightsEqualsExpected() {
        Quantity<WeightUnit> w1 = new Quantity<>(500.0, WeightUnit.GRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(500.0, WeightUnit.GRAM);

        Quantity<WeightUnit> sumWeight = QuantityMeasurementApp.demonstrateAddition(w1, w2);
        Quantity<WeightUnit> expectedWeight = new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("additionOfWeightsEqualsExpected : sumWeight" + sumWeight);
        System.out.println("additionOfWeightsEqualsExpected : expectedWeight" + expectedWeight);
        assertEquals(sumWeight, expectedWeight);
    }

    // Volume Unit test cases
    @Test
    public void testEquality_literToLiter_SameValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertEquals(v1, v2);
    }

    @Test
    public void testEquality_literToLiter_DifferentValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        assertNotEquals(v1, v2);
    }

    @Test
    public void testEquality_literToMilliliter_EquivalentValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITER);
        assertEquals(v1, v2);
    }

    @Test
    public void testEquality_MilliliterToLiter_EquivalentValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1000.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> v2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertEquals(v1, v2);
    }

    @Test
    public void testEquality_LiterToGallon_EquivalentValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(0.264172, VolumeUnit.GALLON);
        assertEquals(v1, v2);
    }

    @Test
    public void testEquality_GallonToLiter_EquivalentValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(0.264172, VolumeUnit.GALLON);
        Quantity<VolumeUnit> v2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertEquals(v1, v2);
    }

    @Test
    public void testEquality_VolumeVsLength_Incompatible() {
        Quantity<LengthUnit> v1 = new Quantity<>(12.0, LengthUnit.INCHES);
        Quantity<VolumeUnit> v2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertNotEquals(v1, v2);
    }

    @Test
    public void testEquality_VolumeVsWeight_Incompatible() {
        Quantity<WeightUnit> v1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<VolumeUnit> v2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertNotEquals(v1, v2);
    }

    @Test
    public void testEquality_Volume_NullComparison() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1000.0, VolumeUnit.LITRE);
        assertNotEquals(v1, null);
    }

    @Test
    public void testEquality_Volume_SameReference() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1000.0, VolumeUnit.LITRE);
        assertEquals(v1, v1);
    }

    @Test
    public void testEquality_Volume_NullUnit() {
        Assert.assertThrows(IllegalArgumentException.class, () ->
                new Quantity<VolumeUnit>(1000.0, null));
    }

    @Test
    public void testEquality_Volume_TransitiveProperty() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> v3 = new Quantity<>(0.264172, VolumeUnit.GALLON);

        assertEquals(v1, v2);
        assertEquals(v2, v3);
        assertEquals(v1, v3);
    }


    @Test
    public void testEquality_Volume_ZeroValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(0.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> v2 = new Quantity<>(0.0, VolumeUnit.LITRE);
        assertEquals(v1, v2);
    }

    @Test
    public void testEquality_NegativeVolume() {
        Quantity<VolumeUnit> v1 = new Quantity<>(-1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(-1000.0, VolumeUnit.MILLILITER);
        assertEquals(v1, v2);
    }

    @Test
    public void testEquality_LargeVolumeValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1000000.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.LITRE);
        assertEquals(v1, v2);
    }

    @Test
    public void testEquality_SmallVolumeValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> v2 = new Quantity<>(0.001, VolumeUnit.LITRE);
        assertEquals(v1, v2);
    }

    @Test
    public void testConversion_LiterToMilliliter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateConversion(v1, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> expectedVolume = new Quantity<>(1000.0, VolumeUnit.MILLILITER);

        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testConversion_MilliliterToLiter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1000.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateConversion(v1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> expectedVolume = new Quantity<>(1.0, VolumeUnit.LITRE);

        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testConversion_GallonToLiter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(0.264172, VolumeUnit.GALLON);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateConversion(v1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> expectedVolume = new Quantity<>(1.0, VolumeUnit.LITRE);

        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testConversion_LiterToGallon() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateConversion(v1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> expectedVolume = new Quantity<>(0.264172, VolumeUnit.GALLON);

        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testConversion_MilliliterToGallon() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1000.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateConversion(v1, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> expectedVolume = new Quantity<>(0.264172, VolumeUnit.GALLON);

        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testConversion_Volume_SameUnit() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateConversion(v1, VolumeUnit.LITRE);
        Quantity<VolumeUnit> expectedVolume = new Quantity<>(1.0, VolumeUnit.LITRE);

        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testConversion_Volume_ZeroValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(0.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateConversion(v1, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> expectedVolume = new Quantity<>(0.0, VolumeUnit.MILLILITER);

        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testConversion_Volume_NegativeValue() {
        Quantity<VolumeUnit> v1 = new Quantity<>(-1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateConversion(v1, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> expectedVolume = new Quantity<>(-1000.0, VolumeUnit.MILLILITER);

        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testConversion_Volume_RoundTrip() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateConversion(v1, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> expectedVolume = QuantityMeasurementApp.demonstrateConversion(v1, VolumeUnit.LITRE);

        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testAddition_SameUnit_LiterPlusLiter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateAddition(v1, v2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> expectedVolume = new Quantity<>(2.0, VolumeUnit.LITRE);

        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testAddition_SameUnit_MilliliterPlusMilliliter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1000.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> v2 = new Quantity<>(1500.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateAddition(v1, v2, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> expectedVolume = new Quantity<>(2500.0, VolumeUnit.MILLILITER);
        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testAddition_CrossUnit_LiterPlusMilliliter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateAddition(v1, v2, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> expectedVolume = new Quantity<>(2000.0, VolumeUnit.MILLILITER);

        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testAddition_CrossUnit_MilliliterPlusLiter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1000.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> v2 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateAddition(v1, v2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> expectedVolume = new Quantity<>(2.0, VolumeUnit.LITRE);

        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testAddition_CrossUnit_GallonPlusLiter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        Quantity<VolumeUnit> v2 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateAddition(v1, v2, VolumeUnit.GALLON);
        Quantity<VolumeUnit> expectedVolume = new Quantity<>(2.0, VolumeUnit.GALLON);

        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Liter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateAddition(v1, v2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> expectedVolume = new Quantity<>(2.0, VolumeUnit.LITRE);

        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Milliliter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateAddition(v1, v2, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> expectedVolume = new Quantity<>(2000.0, VolumeUnit.MILLILITER);

        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Gallon() {
        Quantity<VolumeUnit> v1 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(3.78541, VolumeUnit.LITRE);
        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateAddition(v1, v2, VolumeUnit.GALLON);
        Quantity<VolumeUnit> expectedVolume = new Quantity<>(2.0, VolumeUnit.GALLON);

        assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void testAddition_Volume_Commutativity() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000.0, VolumeUnit.MILLILITER);

        Quantity<VolumeUnit> actualVolume = QuantityMeasurementApp.demonstrateAddition(v1, v2, VolumeUnit.MILLILITER);

        Quantity<VolumeUnit> v3 = new Quantity<>(1000.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> v4 = new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> actualVolume1 = QuantityMeasurementApp.demonstrateAddition(v3, v4, VolumeUnit.LITRE);

        assertTrue(QuantityMeasurementApp.demonstrateEquality(actualVolume, actualVolume1));
    }

    @Test
    public void testAddition_Volume_WithZero() {
        Quantity<VolumeUnit> v1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(0.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> addition = QuantityMeasurementApp.demonstrateAddition(v1, v2, VolumeUnit.LITRE);

        assertEquals(addition, v1);
    }

    @Test
    public void testAddition_Volume_NegativeValues() {
        Quantity<VolumeUnit> v1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(-3000.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> addition = QuantityMeasurementApp.demonstrateAddition(v1, v2, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> expectedAddition = new Quantity<>(2000.0, VolumeUnit.MILLILITER);
        assertEquals(addition, expectedAddition);
    }

    @Test
    public void testAddition_Volume_LargeValues() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1e6, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(1e6, VolumeUnit.LITRE);
        Quantity<VolumeUnit> addition = QuantityMeasurementApp.demonstrateAddition(v1, v2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> expectedAddition = new Quantity<>(2e6, VolumeUnit.LITRE);
        assertEquals(addition, expectedAddition);
    }

    @Test
    public void testAddition_Volume_SmallValues() {
        Quantity<VolumeUnit> v1 = new Quantity<>(0.001, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(0.002, VolumeUnit.LITRE);
        Quantity<VolumeUnit> addition = QuantityMeasurementApp.demonstrateAddition(v1, v2, VolumeUnit.LITRE);
        Quantity<VolumeUnit> expectedAddition = new Quantity<>(0.003, VolumeUnit.LITRE);
        assertEquals(addition, expectedAddition);
    }

    @Test
    public void testVolumeUnitEnum_LiterConstant() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        double v2 = VolumeUnit.LITRE.getConversionFactor();
        assertEquals(v1.getValue(), v2);
    }

    @Test
    public void testVolumeUnitEnum_MilliliterConstant() {
        Quantity<VolumeUnit> v1 = new Quantity<>(0.001, VolumeUnit.MILLILITER);
        double v2 = VolumeUnit.MILLILITER.getConversionFactor();
        assertEquals(v1.getValue(), v2);
    }

    @Test
    public void testVolumeUnitEnum_GallonConstant() {
        Quantity<VolumeUnit> v1 = new Quantity<>(3.78541, VolumeUnit.GALLON);
        double v2 = VolumeUnit.GALLON.getConversionFactor();
        assertEquals(v1.getValue(), v2);
    }

    @Test
    public void testConvertToBaseUnit_LiterToLiter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        double v2 = VolumeUnit.LITRE.convertToBaseUnit(v1.getValue());
        assertEquals(v1.getValue(), v2);
    }

    @Test
    public void testConvertToBaseUnit_MilliliterToLiter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.MILLILITER);
        double v2 = VolumeUnit.LITRE.convertToBaseUnit(v1.getValue());
        assertEquals(v1.getValue(), v2);
    }

    @Test
    public void testConvertToBaseUnit_GallonToLiter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.GALLON);
        double v2 = VolumeUnit.LITRE.convertToBaseUnit(v1.getValue());
        assertEquals(v1.getValue(), v2);
    }

    @Test
    public void testConvertToBaseUnit_LiterToMilliliter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        double v2 = VolumeUnit.MILLILITER.convertFromBaseUnit(v1.getUnit().convertToBaseUnit(v1.getValue()));
        Quantity<VolumeUnit> expected = new Quantity<>(1000.0, VolumeUnit.MILLILITER);
        assertEquals(v2, expected.getValue());
    }

    @Test
    public void testConvertToBaseUnit_LiterToGallon() {
        Quantity<VolumeUnit> v1 = new Quantity<>(1.0, VolumeUnit.LITRE);
        double v2 = VolumeUnit.GALLON.convertFromBaseUnit(v1.getUnit().convertToBaseUnit(v1.getValue()));
        Quantity<VolumeUnit> expected = new Quantity<>(0.2642, VolumeUnit.GALLON);
        assertEquals(v2, expected.getValue());
    }

    // subtract, division test cases
    @Test
    public void testSubtraction_SameUnit_FeetMinusFeet() {
        Quantity<LengthUnit> v1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> subtraction = QuantityMeasurementApp.demonstrateSubtraction(v1, v2);
        Quantity<LengthUnit> expectedAddition = new Quantity<>(5.0, LengthUnit.FEET);
        assertEquals(subtraction, expectedAddition);
    }

    @Test
    public void testSubtraction_SameUnit_LiterMinusLiter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(10.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(3.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> subtraction = QuantityMeasurementApp.demonstrateSubtraction(v1, v2);
        Quantity<VolumeUnit> expectedAddition = new Quantity<>(7.0, VolumeUnit.LITRE);
        assertEquals(subtraction, expectedAddition);
    }

    @Test
    public void testSubtraction_CrossUnit_FeetMinusInches() {
        Quantity<LengthUnit> v1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(6.0, LengthUnit.INCHES);
        Quantity<LengthUnit> subtraction = QuantityMeasurementApp.demonstrateSubtraction(v1, v2);
        Quantity<LengthUnit> expectedAddition = new Quantity<>(9.5, LengthUnit.FEET);
        assertEquals(subtraction, expectedAddition);
    }

    @Test
    public void testSubtraction_CrossUnit_InchesMinusFeet() {
        Quantity<LengthUnit> v1 = new Quantity<>(120.0, LengthUnit.INCHES);
        Quantity<LengthUnit> v2 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> subtraction = QuantityMeasurementApp.demonstrateSubtraction(v1, v2, LengthUnit.FEET);
        Quantity<LengthUnit> expectedAddition = new Quantity<>(60, LengthUnit.INCHES);
        assertEquals(subtraction, expectedAddition);
    }

    @Test
    public void testSubtraction_CrossUnit_ExplicitTargetUnit_Feet() {
        Quantity<LengthUnit> v1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(6.0, LengthUnit.INCHES);
        Quantity<LengthUnit> subtraction = QuantityMeasurementApp.demonstrateSubtraction(v1, v2, LengthUnit.FEET);
        Quantity<LengthUnit> expectedAddition = new Quantity<>(9.5, LengthUnit.FEET);
        assertEquals(subtraction, expectedAddition);
    }

    @Test
    public void testSubtraction_CrossUnit_ExplicitTargetUnit_Inches() {
        Quantity<LengthUnit> v1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(6.0, LengthUnit.INCHES);
        Quantity<LengthUnit> subtraction = QuantityMeasurementApp.demonstrateSubtraction(v1, v2, LengthUnit.INCHES);
        Quantity<LengthUnit> expectedAddition = new Quantity<>(114.0, LengthUnit.INCHES);
        assertEquals(subtraction, expectedAddition);
    }

    @Test
    public void testSubtraction_CrossUnit_ExplicitTargetUnit_Milliliter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> subtraction = QuantityMeasurementApp.demonstrateSubtraction(v1, v2, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> expectedSubtraction = new Quantity<>(3000.0, VolumeUnit.MILLILITER);
        assertEquals(subtraction, expectedSubtraction);
    }

    @Test
    public void testSubtraction_ResultingInNegative() {
        Quantity<LengthUnit> v1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> subtraction = QuantityMeasurementApp.demonstrateSubtraction(v1, v2);
        Quantity<LengthUnit> expectedSubtraction = new Quantity<>(-5.0, LengthUnit.FEET);
        assertEquals(subtraction, expectedSubtraction);
    }

    @Test
    public void testSubtraction_ResultingInZero() {
        Quantity<LengthUnit> v1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(120.0, LengthUnit.INCHES);
        Quantity<LengthUnit> subtraction = QuantityMeasurementApp.demonstrateSubtraction(v1, v2, LengthUnit.FEET);
        Quantity<LengthUnit> expectedSubtraction = new Quantity<>(0.0, LengthUnit.FEET);
        assertEquals(subtraction, expectedSubtraction);
    }

    @Test
    public void testSubtraction_WithZeroOperand() {
        Quantity<LengthUnit> v1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(0.0, LengthUnit.INCHES);
        Quantity<LengthUnit> subtraction = QuantityMeasurementApp.demonstrateSubtraction(v1, v2, LengthUnit.FEET);
        Quantity<LengthUnit> expectedSubtraction = new Quantity<>(5.0, LengthUnit.FEET);
        assertEquals(subtraction, expectedSubtraction);
    }

    @Test
    public void testSubtraction_WithNegativeValues() {
        Quantity<LengthUnit> v1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(-2.0, LengthUnit.FEET);
        Quantity<LengthUnit> subtraction = QuantityMeasurementApp.demonstrateSubtraction(v1, v2);
        Quantity<LengthUnit> expectedSubtraction = new Quantity<>(7.0, LengthUnit.FEET);
        assertEquals(subtraction, expectedSubtraction);
    }

    @Test
    public void testSubtraction_NonCommutative() {
        Quantity<LengthUnit> v1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> subtraction = QuantityMeasurementApp.demonstrateSubtraction(v1, v2);
        Quantity<LengthUnit> subtraction1 = QuantityMeasurementApp.demonstrateSubtraction(v2, v1);
        assertNotEquals(subtraction1, subtraction);
    }


    @Test
    public void testAddition_WithLargeValues() {
        Quantity<WeightUnit> w1 = new Quantity<>(1e6, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(5e5, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> subtraction = QuantityMeasurementApp.demonstrateSubtraction(w1, w2);
        Quantity<WeightUnit> expectedSubtraction = new Quantity<>(5e5, WeightUnit.KILOGRAM);
        assertEquals(subtraction, expectedSubtraction);
    }

    @Test
    public void testSubtraction_WithSmallValues() {
        Quantity<LengthUnit> v1 = new Quantity<>(0.1, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(0.05, LengthUnit.FEET);
        Quantity<LengthUnit> subtraction = QuantityMeasurementApp.demonstrateSubtraction(v1, v2);
        Quantity<LengthUnit> expectedSubtraction = new Quantity<>(0.05, LengthUnit.FEET);
        assertEquals(subtraction, expectedSubtraction);
    }

    @Test
    public void testSubtraction_nullOperand() {

        Assert.assertThrows(NullPointerException.class, () ->
                new Quantity<>(1.0, LengthUnit.FEET).subtract(null));
    }


    @Test
    public void testSubtraction_nullTargetUnit() {
        Assert.assertThrows(IllegalArgumentException.class, () ->
                new Quantity<>(1.0, LengthUnit.FEET)
                        .subtract(new Quantity<>(5.0, LengthUnit.FEET), null));
    }

    @Test
    public void testSubtraction_crossCategory() {
        Quantity<LengthUnit> v1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<WeightUnit> v2 = new Quantity<>(5.0, WeightUnit.KILOGRAM);
        assertThrows(IllegalArgumentException.class, () -> v1.subtract((Quantity) v2));
    }

    @Test// need to check
    public void testSubtraction_allMeasurementCategories() {
        Quantity<LengthUnit> v1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<WeightUnit> v2 = new Quantity<>(5.0, WeightUnit.KILOGRAM);
        assertThrows(IllegalArgumentException.class, () -> v1.subtract((Quantity) v2));
    }

    @Test
    public void testSubtraction_ChainedOperations() {
        Quantity<LengthUnit> v1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> v3 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> subtraction = QuantityMeasurementApp.demonstrateSubtraction(v1, v2).subtract(v3);
        Quantity<LengthUnit> expectedSubtraction = new Quantity<>(7.0, LengthUnit.FEET);
        assertEquals(subtraction, expectedSubtraction);
    }

    @Test
    public void testSubtraction_SameUnit_FeetDivideByFeet() {
        Quantity<LengthUnit> v1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(2.0, LengthUnit.FEET);
        double division = QuantityMeasurementApp.demonstrateDivision(v1, v2);
        double expectedDivision = 5.0;
        assertEquals(division, expectedDivision);
    }

    @Test
    public void testSubtraction_SameUnit_LiterDivideByLiter() {
        Quantity<VolumeUnit> v1 = new Quantity<>(10.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(2.0, VolumeUnit.LITRE);
        double division = QuantityMeasurementApp.demonstrateDivision(v1, v2);
        double expectedDivision = 5.0;
        assertEquals(division, expectedDivision);
    }

    @Test
    public void testSubtraction_CrossUnit_FeetDivideByInches() {
        Quantity<LengthUnit> v1 = new Quantity<>(24.0, LengthUnit.INCHES);
        Quantity<LengthUnit> v2 = new Quantity<>(2.0, LengthUnit.FEET);
        double division = QuantityMeasurementApp.demonstrateDivision(v1, v2);
        double expectedDivision = 1.0;
        assertEquals(division, expectedDivision);
    }

    @Test
    public void testDivision_CrossUnit_KilogramDivideByGram() {
        Quantity<WeightUnit> v1 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> v2 = new Quantity<>(2000.0, WeightUnit.GRAM);
        double division = QuantityMeasurementApp.demonstrateDivision(v1, v2);
        double expectedDivision = 1.0;
        assertEquals(division, expectedDivision);
    }

    @Test
    public void testDivision_RationGraterThanOne() {
        Quantity<LengthUnit> v1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(2.0, LengthUnit.FEET);
        double division = QuantityMeasurementApp.demonstrateDivision(v1, v2);
        assertEquals(5.0, division);
    }

    @Test
    public void testDivision_RationLessThanOne() {
        Quantity<LengthUnit> v1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(10.0, LengthUnit.FEET);
        double division = QuantityMeasurementApp.demonstrateDivision(v1, v2);
        assertEquals(0.5, division);
    }

    @Test
    public void testDivision_RationEqualOne() {
        Quantity<LengthUnit> v1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(10.0, LengthUnit.FEET);
        double division = QuantityMeasurementApp.demonstrateDivision(v1, v2);
        assertEquals(1.0, division);
    }

    @Test
    public void testDivision_NonCommutative() {
        Quantity<LengthUnit> v1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(5.0, LengthUnit.FEET);
        double division = QuantityMeasurementApp.demonstrateDivision(v1, v2);
        double division1 = QuantityMeasurementApp.demonstrateDivision(v2, v1);
        assertNotEquals(division1, division);
    }


    @Test
    void testDivision_ByZero() {
        assertThrows(ArithmeticException.class,
                () -> new Quantity<>(10.0, LengthUnit.FEET)
                        .divide(new Quantity<>(0.0, LengthUnit.FEET)));

    }

    @Test
    void testDivision_WithLargeRatio() {
        Quantity<WeightUnit> v1 = new Quantity<>(1e6, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> v2 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        double division = QuantityMeasurementApp.demonstrateToCheckDivisionRatio(v1, v2);
        double expectedDivision = 1;
        assertEquals(division, expectedDivision);
    }

    @Test
    void testDivision_WithSmallRatio() {
        Quantity<WeightUnit> v1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> v2 = new Quantity<>(1e6, WeightUnit.KILOGRAM);
        double division = QuantityMeasurementApp.demonstrateToCheckDivisionRatio(v1, v2);
        double expectedDivision = -1;
        assertEquals(division, expectedDivision);
    }

    @Test
    public void testDivision_NullOperand() {
            Assert.assertThrows(IllegalArgumentException.class, () ->
                    new Quantity<>(10.0, LengthUnit.FEET).divide(null));
        }

    @Test
    public void testDivision_crossCategory() {
        Quantity<LengthUnit> v1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<WeightUnit> v2 = new Quantity<>(5.0, WeightUnit.KILOGRAM);
        assertThrows(IllegalArgumentException.class, () -> v1.divide((Quantity) v2));
    }

    @Test
    public void testDivision_Associativity() {
        Quantity<LengthUnit> A = new Quantity<>(20.0, LengthUnit.FEET);
        Quantity<LengthUnit> B = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> C = new Quantity<>(2.0,  LengthUnit.FEET);

        double first = A.divide(B);
        Quantity<LengthUnit> firstQuantity = new Quantity<>(first, LengthUnit.FEET);
        double left = firstQuantity.divide(C);

        double second = B.divide(C);
        Quantity<LengthUnit> secondQuantity = new Quantity<>(second, LengthUnit.FEET);
        double right = A.divide(secondQuantity);

        assertNotEquals(left, right);
    }

    @Test
    public void testSubtractionAndDivision_Integration() {
        Quantity<LengthUnit> A = new Quantity<>(20.0, LengthUnit.FEET);
        Quantity<LengthUnit> B = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> C = new Quantity<>(2.0, LengthUnit.FEET);

        Quantity<LengthUnit> diff = A.subtract(B);
        double result = diff.divide(C);
        assertEquals(5.0, result);
    }

    @Test
    public void testSubtractionAndDivision_Inverse() {
        Quantity<LengthUnit> A = new Quantity<>(20.0, LengthUnit.FEET);
        Quantity<LengthUnit> B = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> C = new Quantity<>(2.0, LengthUnit.FEET);

        double result1 = A.add(B).subtract(C).getValue();
        assertEquals(28.0, result1);
    }

    @Test
    public void testSubtraction_Immutability() {
        Quantity<LengthUnit> A = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> B = new Quantity<>(3.0,  LengthUnit.FEET);

        Quantity<LengthUnit> result = A.subtract(B);
        assertEquals(10.0, A.getValue());
        assertEquals(7.0, result.getValue());
    }

    @Test
    public void testDivision_Immutability() {

        Quantity<LengthUnit> A = new Quantity<>(20.0, LengthUnit.FEET);
        Quantity<LengthUnit> B = new Quantity<>(10.0, LengthUnit.FEET);

        double aValueBefore = A.getValue();
        double result = A.divide(B);

        assertEquals(aValueBefore, A.getValue());
        assertEquals(2.0, result);
    }

    @Test
    public void testSubtract_PrecisionAndRounding() {
        Quantity<LengthUnit> A = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> B = new Quantity<>(3.0,  LengthUnit.FEET);
    }
    @Test
    public void testSubtraction_PrecisionAndRounding(){
        Quantity<LengthUnit> ft=new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> ft1=new Quantity<>(1.57, LengthUnit.FEET);
        Quantity<LengthUnit> sub = QuantityMeasurementApp.demonstrateSubtraction(ft,ft1);

        assertEquals(sub, new Quantity<>(3.43,LengthUnit.FEET));
    }

    @Test
    public void testDivision_PrecisionHandling(){
        Quantity<LengthUnit> ft=new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> ft1=new Quantity<>(2.0, LengthUnit.FEET);
        double divPre = QuantityMeasurementApp.demonstrateDivision(ft,ft1);

        assertEquals(divPre,2.50);
    }


}
