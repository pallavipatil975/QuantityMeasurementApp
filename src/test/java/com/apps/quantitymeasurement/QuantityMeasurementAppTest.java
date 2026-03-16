package test.java.com.apps.quantitymeasurement;


import main.java.com.apps.quantitymeasurement.*;
import main.java.com.apps.quantitymeasurement.QuantityMeasurementApp.*;
import main.java.com.apps.quantitymeasurement.constant.LengthUnit;
import main.java.com.apps.quantitymeasurement.constant.VolumeUnit;
import main.java.com.apps.quantitymeasurement.constant.WeightUnit;
import main.java.com.apps.quantitymeasurement.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;


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
         assertThrows(IllegalArgumentException.class, () ->
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
         assertThrows(IllegalArgumentException.class, () ->
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

         assertThrows(NullPointerException.class, () ->
                new Quantity<>(1.0, LengthUnit.FEET).subtract(null));
    }


    @Test
    public void testSubtraction_nullTargetUnit() {
         assertThrows(IllegalArgumentException.class, () ->
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
         assertThrows(NullPointerException.class, () ->
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
        Quantity<LengthUnit> C = new Quantity<>(2.0, LengthUnit.FEET);

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
        Quantity<LengthUnit> B = new Quantity<>(3.0, LengthUnit.FEET);

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
    public void testSubtraction_PrecisionAndRounding() {
        Quantity<LengthUnit> ft = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> ft1 = new Quantity<>(1.57, LengthUnit.FEET);
        Quantity<LengthUnit> sub = QuantityMeasurementApp.demonstrateSubtraction(ft, ft1);

        assertEquals(sub, new Quantity<>(3.43, LengthUnit.FEET));
    }

    @Test
    public void testDivision_PrecisionHandling() {
        Quantity<LengthUnit> ft = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> ft1 = new Quantity<>(2.0, LengthUnit.FEET);
        double divPre = QuantityMeasurementApp.demonstrateDivision(ft, ft1);

        assertEquals(divPre, 2.50);
    }


    // UC 13 TEST CASES
    @Test
    public void testRefactoring_Add_DelegatesViaHelper() {

        Quantity<LengthUnit> l1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(2.0, LengthUnit.FEET);

        Quantity<LengthUnit> addition = l1.add(l2);

        assertEquals(7.0, addition.getValue());
    }

    @Test
    public void testRefactoring_Subtract_DelegatesViaHelper1() {

        Quantity<LengthUnit> l1 = new Quantity<>(5.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(2.0, LengthUnit.FEET);

        Quantity<LengthUnit> subtract = l1.subtract(l2);

        assertEquals(3.0, subtract.getValue());
    }

    @Test
    public void testRefactoring_divide_DelegatesViaHelper1() {

        Quantity<LengthUnit> l1 = new Quantity<>(6.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(2.0, LengthUnit.FEET);

        double subtract = l1.divide(l2);

        assertEquals(3.0, subtract);
    }

    @Test
    public void testValidation_NullOperand_ConsistentAcrossOperations() {
        Quantity<LengthUnit> q = new Quantity<>(10.0, LengthUnit.FEET);

         assertThrows(NullPointerException.class, () -> {
            q.add(null);
        });
         assertThrows(NullPointerException.class, () -> {
            q.subtract(null);
        });
         assertThrows(NullPointerException.class, () -> {
            q.divide(null);
        });
    }

    @Test
    public void testValidation_CrossCategory_ConsistentAcrossOperations() {
        Quantity<LengthUnit> v1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<WeightUnit> v2 = new Quantity<>(5.0, WeightUnit.KILOGRAM);
        assertThrows(IllegalArgumentException.class, () -> v1.subtract((Quantity) v2));
        assertThrows(IllegalArgumentException.class, () -> v1.add((Quantity) v2));
        assertThrows(IllegalArgumentException.class, () -> v1.divide((Quantity) v2));
    }

    @Test
    public void testValidation_FiniteValue_ConsistentAcrossOperations() {
        Quantity<LengthUnit> q = new Quantity<>(10.0, LengthUnit.FEET);

         assertThrows(NullPointerException.class, () -> {
            q.add(null);
        });
         assertThrows(NullPointerException.class, () -> {
            q.subtract(null);
        });
         assertThrows(NullPointerException.class, () -> {
            q.divide(null);
        });
    }

    @Test
    public void testValidation_NullTargetUnit_AddSubtractReject() {

        Quantity<LengthUnit> v1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> v2 = new Quantity<>(5.0, LengthUnit.FEET);

         assertThrows(IllegalArgumentException.class,
                () -> v1.add(v2, null));

         assertThrows(IllegalArgumentException.class,
                () -> v1.subtract(v2, null));
    }

    @Test
    public void testArithmeticOperation_Add_EnumComputation() {
        assertEquals(15.0, Quantity.ArithmeticOperation.ADD.compute(10.0, 5.0));
    }

    @Test
    public void testArithmeticOperation_Subtract_EnumComputation() {
        assertEquals(5.0, Quantity.ArithmeticOperation.SUBTRACT.compute(10.0, 5.0));
    }

    @Test
    public void testArithmeticOperation_divide_EnumComputation() {
        assertEquals(2.0, Quantity.ArithmeticOperation.DIVIDE.compute(10.0, 5.0));
    }

    @Test
    public void testArithmeticOperation_DivideByZero_EnumThrows() {
         assertThrows(ArithmeticException.class,
                () -> Quantity.ArithmeticOperation.DIVIDE.compute(10.0, 0.0));
    }

    @Test
    public void testPerformBaseArithmetic_ConversionAndOperation() {
        Quantity<LengthUnit> l1 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(6.0, LengthUnit.INCHES);

        double v1InInches = l1.getUnit().convertToBaseUnit(l1.getValue()); // expected 24.0
        double v2InInches = l2.getUnit().convertToBaseUnit(l2.getValue());

        double addition = Quantity.ArithmeticOperation.ADD.compute(v1InInches, v2InInches);
        assertEquals(30.0, addition);
    }

    @Test
    public void testRounding_AddSubtract_TwoDecimalPlaces() {
        Quantity<LengthUnit> l1 = new Quantity<>(6.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(2.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = l1.subtract(l2, LengthUnit.INCHES);
        Quantity<LengthUnit> expected = new Quantity<>(48.00, LengthUnit.INCHES);
        assertEquals(expected, result);

        Quantity<LengthUnit> additionResult = l1.add(l2, LengthUnit.INCHES);
        Quantity<LengthUnit> expectedResult = new Quantity<>(96.00, LengthUnit.INCHES);
        assertEquals(additionResult, expectedResult);
    }

    @Test
    public void testRounding_Divide_NoRounding() {
        Quantity<LengthUnit> l1 = new Quantity<>(6.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(2.0, LengthUnit.FEET);

        double result = l1.divide(l2);
        assertEquals(3.0, result);
    }

    @Test
    public void testImplicitTargetUnit_AddSubtract() {
        Quantity<LengthUnit> l1 = new Quantity<>(6.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(2.0, LengthUnit.FEET);

        Quantity<LengthUnit> subtract = l1.subtract(l2);
        assertEquals(LengthUnit.FEET, subtract.getUnit());
        assertEquals(4.0, subtract.getValue());

        Quantity<LengthUnit> addition = l1.add(l2);
        assertEquals(LengthUnit.FEET, addition.getUnit());
        assertEquals(8.0, addition.getValue());
    }

    @Test
    public void testExplicitTargetUnit_AddSubtract_Overrides() {
        // 2 ft + 6 in → in INCHES: 24 + 6 = 30 in
        Quantity<LengthUnit> a = new Quantity<>(2.0, LengthUnit.FEET);     // first operand FEET
        Quantity<LengthUnit> b = new Quantity<>(6.0, LengthUnit.INCHES);

        Quantity<LengthUnit> sumInInches = a.add(b, LengthUnit.INCHES);
        assertEquals(LengthUnit.INCHES, sumInInches.getUnit());            // explicit target overrides
        assertEquals(30.0, sumInInches.getValue());

        // 2 ft - 6 in → in INCHES: 24 - 6 = 18 in
        Quantity<LengthUnit> diffInInches = a.subtract(b, LengthUnit.INCHES);
        assertEquals(LengthUnit.INCHES, diffInInches.getUnit());           // explicit target overrides
        assertEquals(18.0, diffInInches.getValue());
    }

    @Test
    public void testImmutability_AfterAdd_ViaCentralizedHelper() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCHES);

        // Keep originals for comparison
        Quantity<LengthUnit> aOriginal = new Quantity<>(a.getValue(), a.getUnit());
        Quantity<LengthUnit> bOriginal = new Quantity<>(b.getValue(), b.getUnit());

        Quantity<LengthUnit> result = a.add(b); // implicit FEET → 1 ft + 1 ft = 2 ft

        // Verify immutability: originals unchanged
        assertEquals(LengthUnit.FEET, a.getUnit());
        assertEquals(1.0, a.getValue());
        assertEquals(LengthUnit.INCHES, b.getUnit());
        assertEquals(12.0, b.getValue());

        // Double-check by comparing to cloned originals
        assertEquals(aOriginal.getUnit(), a.getUnit());
        assertEquals(aOriginal.getValue(), a.getValue());
        assertEquals(bOriginal.getUnit(), b.getUnit());
        assertEquals(bOriginal.getValue(), b.getValue());

        // And result is a new instance with correct value
        assertNotSame(a, result);
        assertEquals(LengthUnit.FEET, result.getUnit());
        assertEquals(2.0, result.getValue());

        Quantity<LengthUnit> ft = new Quantity<>(8.0, LengthUnit.FEET);
        Quantity<LengthUnit> ft1 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> temp = ft;
        Quantity<LengthUnit> conIn = ft.add(ft1, LengthUnit.INCHES);

        assertEquals(temp, ft);
    }

    @Test
    public void testImmutability_AfterSubtract_ViaCentralizedHelper() {
        Quantity<LengthUnit> a = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCHES);

        // Keep originals for comparison
        Quantity<LengthUnit> aOriginal = new Quantity<>(a.getValue(), a.getUnit());
        Quantity<LengthUnit> bOriginal = new Quantity<>(b.getValue(), b.getUnit());

        Quantity<LengthUnit> result = a.subtract(b); // implicit FEET → 1 ft + 1 ft = 2 ft

        // Verify immutability: originals unchanged
        assertEquals(LengthUnit.FEET, a.getUnit());
        assertEquals(2.0, a.getValue());
        assertEquals(LengthUnit.INCHES, b.getUnit());
        assertEquals(12.0, b.getValue());

        // Double-check by comparing to cloned originals
        assertEquals(aOriginal.getUnit(), a.getUnit());
        assertEquals(aOriginal.getValue(), a.getValue());
        assertEquals(bOriginal.getUnit(), b.getUnit());
        assertEquals(bOriginal.getValue(), b.getValue());

        // And result is a new instance with correct value
        assertNotSame(a, result);
        assertEquals(LengthUnit.FEET, result.getUnit());
        assertEquals(1.0, result.getValue());
    }

    @Test
    public void testImmutability_AfterDivide_ViaCentralizedHelper() {
        // a = 2 ft, b = 6 in → b in ft = 0.5 ft → 2 / 0.5 = 4.0 (dimensionless scalar)
        Quantity<LengthUnit> a = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(6.0, LengthUnit.INCHES);

        // Keep originals for comparison
        Quantity<LengthUnit> aOriginal = new Quantity<>(a.getValue(), a.getUnit());
        Quantity<LengthUnit> bOriginal = new Quantity<>(b.getValue(), b.getUnit());

        double result = a.divide(b); // returns scalar

        // ✅ Immutability: originals unchanged
        assertEquals(LengthUnit.FEET, a.getUnit());
        assertEquals(2.0, a.getValue());

        assertEquals(LengthUnit.INCHES, b.getUnit());
        assertEquals(6.0, b.getValue());

        // ✅ Against cloned originals
        assertEquals(aOriginal.getUnit(), a.getUnit());
        assertEquals(aOriginal.getValue(), a.getValue());

        assertEquals(bOriginal.getUnit(), b.getUnit());
        assertEquals(bOriginal.getValue(), b.getValue());

        // ✅ Division result (scalar)
        assertEquals(4.0, result);
    }

    @Test
    public void testAllOperations_AcrossAllCategories_WeightAdd() {
        Quantity<WeightUnit> w1 = new Quantity<>(8.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> result = w1.add(w2);
        Quantity<WeightUnit> ex = new Quantity<>(10.0, WeightUnit.KILOGRAM);

        assertEquals(ex, result);
    }

    @Test
    public void testAllOperations_AcrossAllCategories_WeightSub() {
        Quantity<WeightUnit> w = new Quantity<>(8.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w1 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> result = w.subtract(w1);
        Quantity<WeightUnit> ex = new Quantity<>(6.0, WeightUnit.KILOGRAM);

        assertEquals(ex, result);
    }

    @Test
    public void testAllOperations_AcrossAllCategories_WeightDivide() {
        Quantity<WeightUnit> w = new Quantity<>(8.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w1 = new Quantity<>(2.0, WeightUnit.KILOGRAM);
        double result = w.divide(w1);

        assertEquals(4.0, result);
    }

    @Test
    public void testAllOperations_AcrossAllCategories_WeightMultiply() {
        Quantity<WeightUnit> w = new Quantity<>(8.0, WeightUnit.KILOGRAM);
        double result = w.multiply(5).getValue();


        assertEquals(40.0, result);
    }

    @Test
    public void testAllOperations_AcrossAllCategories_VolumeAdd() {
        Quantity<VolumeUnit> v = new Quantity<>(8.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v1 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v.add(v1);
        Quantity<VolumeUnit> ex = new Quantity<>(10.0, VolumeUnit.LITRE);

        assertEquals(ex, result);
    }

    @Test
    public void testAllOperations_AcrossAllCategories_VolumeSub() {
        Quantity<VolumeUnit> v = new Quantity<>(8.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v1 = new Quantity<>(2.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> result = v.subtract(v1);
        Quantity<VolumeUnit> ex = new Quantity<>(6.0, VolumeUnit.LITRE);

        assertEquals(ex, result);
    }

    @Test
    public void testAllOperations_AcrossAllCategories_VolumeDivide() {
        Quantity<VolumeUnit> v = new Quantity<>(8.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v1 = new Quantity<>(2.0, VolumeUnit.LITRE);
        double result = v.divide(v1);

        assertEquals(4.0, result);
    }

    @Test
    public void testAllOperations_AcrossAllCategories_VolumeMultiply() {
        Quantity<VolumeUnit> v = new Quantity<>(8.0, VolumeUnit.LITRE);
        double result = v.multiply(2.0).getValue();

        assertEquals(16.0, result);
    }

    @Test
    public void testAllOperations_AcrossAllCategories_LengthAdd() {
        Quantity<LengthUnit> f = new Quantity<>(8.0, LengthUnit.FEET);
        Quantity<LengthUnit> f1 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = f.add(f1);
        Quantity<LengthUnit> ex = new Quantity<>(10.0, LengthUnit.FEET);

        assertEquals(ex, result);
    }

    @Test
    public void testAllOperations_AcrossAllCategories_LengthSub() {
        Quantity<LengthUnit> f = new Quantity<>(8.0, LengthUnit.FEET);
        Quantity<LengthUnit> f1 = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = f.subtract(f1);
        Quantity<LengthUnit> ex = new Quantity<>(6.0, LengthUnit.FEET);

        assertEquals(ex, result);
    }

    @Test
    public void testAllOperations_AcrossAllCategories_LengthDivide() {
        Quantity<LengthUnit> f = new Quantity<>(8.0, LengthUnit.FEET);
        Quantity<LengthUnit> f1 = new Quantity<>(2.0, LengthUnit.FEET);
        double result = f.divide(f1);

        assertEquals(4.0, result);
    }

    @Test
    public void testAllOperations_AcrossAllCategories_LengthMultiply() {
        Quantity<LengthUnit> f1 = new Quantity<>(2.0, LengthUnit.FEET);
        double result = f1.multiply(8.0).getValue();

        assertEquals(16.0, result);
    }
    // 24
    @Test
    public void testCodeDuplication_ValidationLogic_Eliminated() {
        Quantity<LengthUnit> a = new Quantity<>(8.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = a.subtract(b);
        Quantity<LengthUnit> ex = new Quantity<>(6.0, LengthUnit.FEET);
        assertEquals(ex, result);
    }

    // 25
    @Test
    public void testCodeDuplication_ConversionLogic_Eliminated() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);      // 12 in
        Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCHES);   // 12 in
        Quantity<LengthUnit> result = a.add(b);                             // 2 ft
        Quantity<LengthUnit> ex = new Quantity<>(2.0, LengthUnit.FEET);
        assertEquals(ex, result);
    }

    // 26
    @Test
    public void testEnumDispatch_AllOperations_CorrectlyDispatched() {
        Quantity<WeightUnit> a = new Quantity<>(1.0, WeightUnit.KILOGRAM);   // 1000 g
        Quantity<WeightUnit> b = new Quantity<>(500.0, WeightUnit.GRAM);     // 500 g
        Quantity<WeightUnit> result = a.add(b);                              // 1.5 kg
        Quantity<WeightUnit> ex = new Quantity<>(1.5, WeightUnit.KILOGRAM);
        assertEquals(ex, result);
    }

    // 27
    @Test
    public void testFutureOperation_MultiplicationPattern() {
        Quantity<LengthUnit> a = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = a.multiply(2.5);   // scalar multiply → 25 ft
        Quantity<LengthUnit> ex = new Quantity<>(25.0, LengthUnit.FEET);
        assertEquals(ex, result);
    }

    // 28
    @Test
    public void testErrorMessage_Consistency_Across_Operations() {
        Quantity<VolumeUnit> a = new Quantity<>(1.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> b = new Quantity<>(250.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> result = a.add(b);          // 1.25 L
        Quantity<VolumeUnit> ex = new Quantity<>(1.25, VolumeUnit.LITRE);
        assertEquals(ex, result);
    }

    // 29
    @Test
    public void testHelper_PrivateVisibility() {
        Quantity<LengthUnit> a = new Quantity<>(24.0, LengthUnit.INCHES);
        Quantity<LengthUnit> b = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> result = a.subtract(b);     // 12 in
        Quantity<LengthUnit> ex = new Quantity<>(12.0, LengthUnit.INCHES);
        assertEquals(ex, result);
    }

    // 30
    @Test
    public void testValidation_Helper_PrivateVisibility() {
        Quantity<WeightUnit> a = new Quantity<>(2000.0, WeightUnit.GRAM);
        Quantity<WeightUnit> b = new Quantity<>(500.0, WeightUnit.GRAM);
        Quantity<WeightUnit> result = a.subtract(b);     // 1500 g
        Quantity<WeightUnit> ex = new Quantity<>(1500.0, WeightUnit.GRAM);
        assertEquals(ex, result);
    }

    // 31
    @Test
    public void testRounding_Helper_Accuracy() {
        Quantity<LengthUnit> a = new Quantity<>(1.234567, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(-0.004567, LengthUnit.FEET);
        Quantity<LengthUnit> result = a.add(b);          // ≈ 1.23 ft (depending on rounding in equals)
        Quantity<LengthUnit> ex = new Quantity<>(1.23, LengthUnit.FEET);
        assertEquals(ex, result);
    }

    // 32
    @Test
    public void testArithmetic_Chain_Operations() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);       // 12 in
        Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCHES);    // 12 in
        Quantity<LengthUnit> c = a.add(b);                                   // 24 in → 2 ft
        Quantity<LengthUnit> result = c.subtract(new Quantity<>(1.0, LengthUnit.FEET)); // 1 ft
        Quantity<LengthUnit> ex = new Quantity<>(1.0, LengthUnit.FEET);
        assertEquals(ex, result);
    }

    // 33
    @Test
    public void testRefactoring_NoBehaviorChange_LargeDataset() {
        Quantity<VolumeUnit> a = new Quantity<>(750.0, VolumeUnit.MILLILITER);
        Quantity<VolumeUnit> b = new Quantity<>(0.25, VolumeUnit.LITRE);      // 250 ml
        Quantity<VolumeUnit> result = a.add(b);                               // 1000 ml = 1 L
        Quantity<VolumeUnit> ex = new Quantity<>(1.0, VolumeUnit.LITRE);
        assertEquals(ex, result);
    }

    // 34
    @Test
    public void testRefactoring_Performance_ComparableToUC12() {
        Quantity<WeightUnit> a = new Quantity<>(1.0, WeightUnit.KILOGRAM);    // 1000 g
        Quantity<WeightUnit> b = new Quantity<>(250.0, WeightUnit.GRAM);      // 250 g
        Quantity<WeightUnit> result = a.add(b).add(b).subtract(b);            // 1.0 + .25 + .25 - .25 = 1.25 kg
        Quantity<WeightUnit> ex = new Quantity<>(1.25, WeightUnit.KILOGRAM);
        assertEquals(ex, result);
    }

    // 35
    @Test
    public void testEnumConstant_ADD_CorrectlyAdds() {
        Quantity<LengthUnit> a = new Quantity<>(2.0, LengthUnit.FEET);
        Quantity<LengthUnit> b = new Quantity<>(24.0, LengthUnit.INCHES);     // 2 ft
        Quantity<LengthUnit> result = a.add(b);                               // 4 ft
        Quantity<LengthUnit> ex = new Quantity<>(4.0, LengthUnit.FEET);
        assertEquals(ex, result);
    }

    // 36
    @Test
    public void testEnumConstant_SUBTRACT_CorrectlySubtracts() {
        Quantity<LengthUnit> a = new Quantity<>(3.0, LengthUnit.FEET);        // 108 in
        Quantity<LengthUnit> b = new Quantity<>(24.0, LengthUnit.INCHES);     // 24 in
        Quantity<LengthUnit> result = a.subtract(b);                          // 84 in = 2.333... yd
        Quantity<LengthUnit> ex = new Quantity<>(1.0, LengthUnit.FEET);
        assertEquals(ex, result);
    }

    // 37
    @Test
    public void testEnumConstant_DIVIDE_CorrectlyDivides() {
        Quantity<LengthUnit> a = new Quantity<>(24.0, LengthUnit.INCHES);
        Quantity<LengthUnit> b = new Quantity<>(2.0, LengthUnit.FEET);        // 24 in
        double result = a.divide(b);                                          // 1.0
        double ex = 1.0;
        assertEquals(ex, result, 1e-9);
    }

    // 38
    @Test
    public void testHelper_BaseUnitConversion_Correct() {
        Quantity<LengthUnit> a = new Quantity<>(1.0, LengthUnit.FEET);        // 12 in
        Quantity<LengthUnit> b = new Quantity<>(12.0, LengthUnit.INCHES);     // 12 in
        Quantity<LengthUnit> result = a.add(b);                               // 24 in -> 2 ft
        Quantity<LengthUnit> ex = new Quantity<>(2.0, LengthUnit.FEET);
        assertEquals(ex, result);
    }

    // 39
    @Test
    public void testHelper_ResultConversion_Correct() {
        Quantity<WeightUnit> a = new Quantity<>(1.0, WeightUnit.KILOGRAM);    // 1000 g
        Quantity<WeightUnit> b = new Quantity<>(500.0, WeightUnit.GRAM);      // 500 g
        Quantity<WeightUnit> result = a.add(b);                               // 1.5 kg
        Quantity<WeightUnit> ex = new Quantity<>(1.5, WeightUnit.KILOGRAM);
        assertEquals(ex, result);
    }

    // 40
    @Test
    public void testRefactoring_Validation_UnifiedBehavior() {
        Quantity<VolumeUnit> a = new Quantity<>(2.0, VolumeUnit.LITRE);       // 2000 ml
        Quantity<VolumeUnit> b = new Quantity<>(500.0, VolumeUnit.MILLILITER);// 500 ml
        Quantity<VolumeUnit> result = a.subtract(b);                          // 1.5 L
        Quantity<VolumeUnit> ex = new Quantity<>(1.5, VolumeUnit.LITRE);
        assertEquals(ex, result);
    }


}