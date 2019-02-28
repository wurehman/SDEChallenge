package com.paytm.challenge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleMovingAverageTest {

    private SimpleMovingAverage movingAverage;

    private static final double DELTA = 1e-15;


    public SimpleMovingAverageTest() {
        movingAverage = new SimpleMovingAverage<Long>();
    }

    @Before
    public void init() {
    }

    @Test
    public void addElementNullTest() {

        movingAverage.addElement(null);
        assertEquals(0, movingAverage.getSize());
    }

    @Test
    public void addElementOneTest() {

        movingAverage.addElement(10);
        assertEquals(1, movingAverage.getSize());
        assertEquals(10, movingAverage.getElement(0));
    }

    @Test
    public void addElementFirstTest() {
        movingAverage.addElement(2.1d);
        movingAverage.addElement(4.0d);
        movingAverage.addElement(10.3d);
        assertEquals(3, movingAverage.getSize());
        //The element at index 0 should be the last one added
        assertEquals(10.3d, movingAverage.getElement(0));
    }

    @Test
    public void getElementEmptyListTest() {
        try {
            Number number = movingAverage.getElement(0);
            fail("IndexOutofBoundException should have been thrown");
        } catch (IndexOutOfBoundsException e) {
            //Pass
            assertTrue(true);
        }

    }

    @Test
    public void getElementInvalidIndexTest() {
        try {
            Number number = movingAverage.getElement(0);
            fail("IndexOutofBoundException should have been thrown");
        } catch (IndexOutOfBoundsException e) {
            //Pass
            assertTrue(true);
        }

    }

    @Test
    public void getElementValidIndexTest() {

        movingAverage.addElement(2.1d);
        movingAverage.addElement(4.0d);
        movingAverage.addElement(10.3d);
        assertEquals(3, movingAverage.getSize());
        //The element at index 0 should be the last one added
        assertEquals(10.3d, movingAverage.getElement(0));
        assertEquals(4.0d, movingAverage.getElement(1));
        assertEquals(2.1d, movingAverage.getElement(2));
    }

    @Test
    public void getMovingAverageEmptyList() {
        assertEquals(0d, movingAverage.getMovingAverage(1), DELTA);
    }

    @Test
    public void getMovingAverageSizeEqualsN_1() {
        movingAverage.addElement(2.1d);
        assertEquals(2.1d, movingAverage.getMovingAverage(1), DELTA);
    }

    @Test
    public void getMovingAverageSizeEqualsN_3() {
        movingAverage.addElement(3.5d);
        movingAverage.addElement(2.1d);
        movingAverage.addElement(4.0d);
        movingAverage.addElement(6.3d);
        assertEquals(3.98d, movingAverage.getMovingAverage(4), DELTA);
    }

    @Test
    public void getMovingAverageSizeLessThanN() {
        movingAverage.addElement(2.16d);
        movingAverage.addElement(3.53d);
        assertEquals(1.14d, movingAverage.getMovingAverage(5), DELTA);
    }

    @Test
    public void getMovingAverageSizeGreaterThanN() {
        movingAverage.addElement(2.16d);
        movingAverage.addElement(3.53d);
        movingAverage.addElement(4.01d);
        movingAverage.addElement(6.34d);
        assertEquals(4.63d, movingAverage.getMovingAverage(3), DELTA);
    }
}
