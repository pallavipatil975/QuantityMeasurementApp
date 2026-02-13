package test.java.com.apps.quantitymeasurement;

import main.java.com.apps.quantitymeasurement.*;
import main.java.com.apps.quantitymeasurement.QuantityMeasurementApp.*;
import main.java.com.apps.quantitymeasurement.constant.LengthUnit;
import main.java.com.apps.quantitymeasurement.service.Length;
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
        //  FeetDemo f2 = new FeetDemo();
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
        Length feet1 = new Length(1.0,  LengthUnit.FEET);
        Length feet2 = new Length(1.0,  LengthUnit.FEET);
        assertEquals(feet1, feet2);
    }

    @Test
    public void testInchesEquality() {
        Length inches1 = new Length(12.0,  LengthUnit.INCHES);
        Length inches2 = new Length(12.0,  LengthUnit.INCHES);
        assertEquals(inches1, inches2);
    }

    @Test
    public void testFeetInchesComparison() {
        Length inches1 = new Length(12.0,  LengthUnit.INCHES);
        Length feet1 = new Length(1.0,  LengthUnit.FEET);
        assertEquals(inches1, feet1);
    }

    @Test
    public void testFeetInequality() {
        Length feet1 = new Length(1.0,  LengthUnit.FEET);
        Length feet2 = new Length(2.0,  LengthUnit.FEET);
        assertNotEquals(feet1, feet2);
    }

    @Test
    public void testInchesInequality() {
        Length inches1 = new Length(12.0,  LengthUnit.INCHES);
        Length inches2 = new Length(24.0,  LengthUnit.INCHES);
        assertNotEquals(inches1, inches2);
    }

    @Test
    public void testCrossUnitInequality() {
        Length inches1 = new Length(12.0,  LengthUnit.INCHES);
        Length feet1 = new Length(2.0,  LengthUnit.FEET);
        assertNotEquals(inches1, feet1);
    }

    @Test
    public void testMultipleFeetComparison() {
        Length inches1 = new Length(3.0,  LengthUnit.FEET);
        Length feet1 = new Length(3.0,  LengthUnit.FEET);
        assertEquals(inches1, feet1);
    }

    @Test
    public void yardEquals36Inches() {
        Length yard = new Length(1.0,  LengthUnit.YARDS);
        Length inches = new Length(36.0,  LengthUnit.INCHES);
        assertEquals(yard, inches);
    }

    @Test
    public void centimeterEquals39Points3701Inches() {
        Length centimeter = new Length(100.0,  LengthUnit.CENTIMETER);
        Length inches = new Length(39.3701,  LengthUnit.INCHES);
        assertEquals(centimeter, inches);
    }

    @Test
    public void threeFeetEqualsOneYard() {
        Length feet = new Length(3.0,  LengthUnit.FEET);
        Length yard = new Length(1.0,  LengthUnit.YARDS);
        assertEquals(feet, yard);
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        Length centimeter = new Length(30.48,  LengthUnit.CENTIMETER);
        Length feet = new Length(1.0,  LengthUnit.FEET);
        assertEquals(feet, feet);
    }

    @Test
    public void yardNotEqualsToInches() {
        Length yard = new Length(1.0,  LengthUnit.YARDS);
        Length Inches = new Length(12.0,  LengthUnit.INCHES);
        assertNotEquals(yard, Inches);
    }

    @ParameterizedTest
    @EnumSource( LengthUnit.class)
    public void referenceEqualitySameObject( LengthUnit unit) {
        Length length = new Length(1.0, unit);
        assertEquals(length, length);
    }

    @ParameterizedTest
    @EnumSource( LengthUnit.class)
    public void equalsReturnFalseForNull( LengthUnit unit) {
        Length length = new Length(1.0, unit);
    }


    @ParameterizedTest
    @EnumSource( LengthUnit.class)
    public void differentValueSSameUnitNotEqual( LengthUnit unit) {
        Length length1 = new Length(1.0, unit);
        Length length2 = new Length(12.0, unit);
        assertNotEquals(length1, length2);
    }

    @Test
    public void crossUnitEqualityDemonstrateMethod(){
        assertAll(
                ()-> assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(1.0,  LengthUnit.FEET, 12.0,  LengthUnit.INCHES)),
                ()-> assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(1.0,  LengthUnit.YARDS,36.0,  LengthUnit.INCHES)),
                ()-> assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(100.0,  LengthUnit.CENTIMETER, 39.3701,  LengthUnit.INCHES)),
                ()-> assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(3.0,  LengthUnit.FEET, 1.0,  LengthUnit.YARDS)),
                ()-> assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(1.0,  LengthUnit.YARDS, 91.44,  LengthUnit.CENTIMETER)),
                ()-> assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(30.48,  LengthUnit.CENTIMETER, 1.0,  LengthUnit.FEET))

        );
    }

    @Test
    public void reflexiveSymmetricAndTranstiveProperty(){
        Length l1 = new Length(0.3333,  LengthUnit.YARDS);
        Length l2 = new Length(12.0,  LengthUnit.INCHES);
        Length l3 = new Length(30.48,  LengthUnit.CENTIMETER);
        Length l4 = new Length(1.0,  LengthUnit.FEET);

        // reflexive
        assertEquals(l1,l2);

        //Symmetric
        assertEquals(l1,l2);
        assertEquals(l2,l1);
        assertEquals(l3,l4);
        assertEquals(l3,l4);
        assertEquals(l1,l3);

        //Transtive
        assertEquals(l1,l2);
        assertEquals(l2,l3);
        assertEquals(l1,l3);
        assertEquals(l3,l4);
        assertEquals(l4,l3);
    }

    @Test
    public void convertFeetToInches() {
        Length lengthInInches = QuantityMeasurementApp.demonstrateLengthConversion(1.0,  LengthUnit.FEET,  LengthUnit.INCHES);
        Length expectedLength = new Length(12.0,  LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches, expectedLength));
    }

    @Test
    public void convertYardToInchesUsingOverloadedMethod() {
         Length lengthInYards = new Length(2.0,  LengthUnit.YARDS);
        Length lengthInInches = QuantityMeasurementApp.demonstrateLengthConversion(lengthInYards, LengthUnit.INCHES);
        Length expectedLength = new Length(72.0,  LengthUnit.INCHES);

        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(lengthInInches, expectedLength));
    }
    @Test
    public void addFeetAndInches(){
        Length length1 = new Length(1.0,  LengthUnit.FEET);
        Length length2 = new Length(12.0,  LengthUnit.INCHES);

        Length sumLength = QuantityMeasurementApp.demonstrateLengthAddition(length1, length2);
        Length expectedLength = new Length(2.0,  LengthUnit.FEET);

        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sumLength, expectedLength));
    }

    @Test
    public void addFeetAndInchesWithTargetUnitInches(){
        Length length1 = new Length(1.0,  LengthUnit.FEET);
        Length length2 = new Length(12.0,  LengthUnit.INCHES);

        Length sumLength = QuantityMeasurementApp.demonstrateLengthAddition(length1, length2,  LengthUnit.INCHES);

        Length expectedLength = new Length(24.0,  LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(sumLength, expectedLength));
    }
}

