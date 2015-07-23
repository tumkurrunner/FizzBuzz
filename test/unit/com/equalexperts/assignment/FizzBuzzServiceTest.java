package com.equalexperts.assignment;


import com.equalexperts.assignment.validators.RangeValidation;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzServiceTest {

    private IFizzBuzzService fizzBuzz;

    @Mock
    private RangeValidation rangeValidation;

    @Before
    public void init() {
        fizzBuzz = new FizzBuzzService(rangeValidation);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForInvalidRanges() {
        doThrow(IllegalArgumentException.class).when(rangeValidation).validateRange(anyInt(), anyInt());
        fizzBuzz.execute(0, 2);
    }

    @Test
    public void shouldTransformWithNumbers() {
        doNothing().when(rangeValidation).validateRange(anyInt(), anyInt());
        assertEquals(fizzBuzz.execute(1, 2), "1 2");
    }

    @Test
    public void shouldTransformWithFizz() {
        doNothing().when(rangeValidation).validateRange(anyInt(), anyInt());
        assertEquals(fizzBuzz.execute(1, 3), "1 2 fizz");
    }

    @Test
    public void shouldTransformWithFizzAndBuzz() {
        doNothing().when(rangeValidation).validateRange(anyInt(), anyInt());
        assertEquals(fizzBuzz.execute(4, 5), "4 buzz");
    }

    @Test
    public void shouldTransformWithFizzBuzz() {
        doNothing().when(rangeValidation).validateRange(anyInt(), anyInt());
        assertEquals(fizzBuzz.execute(15, 16), "fizzbuzz 16");
    }

    @Test
    public void shouldTransformWithFizzAndBuzzAndFizzBuzz() {
        doNothing().when(rangeValidation).validateRange(anyInt(), anyInt());
        assertEquals(fizzBuzz.execute(1, 16), "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16");
    }
}
