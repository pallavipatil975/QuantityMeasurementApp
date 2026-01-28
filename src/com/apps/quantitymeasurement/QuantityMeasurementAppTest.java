package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementApp.FeetDemo;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class QuantityMeasurementAppTest {
    @Test
    public void testFeetEquality_SameValue(){
      Feet f1 = new Feet(1.0);
      Feet f2 = new Feet(1.0);
      assertEquals(f1, f2);
    }
    @Test
    public void testFeetEquality_dfferentValue(){
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(2.0);
        assertNotEquals(f1, f2);
    }
    @Test
    public void testFeetEquality_NullComparison(){
        Feet f1 = new Feet(1.0);
        assertNotEquals(f1, null);
    }
    @Test
    public void testFeetEquality_differentClass(){
        Feet f1 = new Feet(1.0);
        FeetDemo f2 = new FeetDemo();
        assertNotEquals(f1, f2);
    }
    @Test
    public void testFeetEquality_SameReference(){
        Feet f1 = new Feet(1.0);
        assertEquals(f1, f1);
    }
}
