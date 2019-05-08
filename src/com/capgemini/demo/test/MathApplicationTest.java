package com.capgemini.demo.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.demo.MathApplication;
import com.capgemini.demo.Exception.NegativeNumberException;
import com.capgemini.demo.service.CalculatorService;


public class MathApplicationTest {

	@Mock
	private CalculatorService service;

	@InjectMocks
	MathApplication application = new MathApplication(service);

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testPerformAdditionWithTwoPositiveIntegers() {
		when(service.addition(4, 6)).thenReturn(10);
		assertEquals(10, application.performAddition(4, 6));
	}

	@Test
	public void testPerformAdditionWithTwoNegativeIntegers() {
		when(service.addition(-2, -3)).thenReturn(-5);
		assertEquals(-5, application.performAddition(-2, -3));
	}

	@Test
	public void testPerformAdditionWithOnePositiveOneNegativeIntegers() {
		when(service.addition(2, -3)).thenReturn(-1);
		assertEquals(-1, application.performAddition(2, -3));
	}

	@Test
	public void testPerformSubtractionWithTwoNegativeIntegers() {
		when(service.subtraction(-8, -2)).thenReturn(-10);
		assertEquals(-10, application.performSubtraction(-8, -2));
	}

	@Test
	public void testPerformSubtractionWithTwoPositiveIntegers() {
		when(service.subtraction(8, 6)).thenReturn(14);
		assertEquals(14, application.performSubtraction(8, 6));
	}

	@Test
	public void testPerformSubtarctionWithOnePositiveOneNegativeIntegers() {
		when(service.subtraction(2, -3)).thenReturn(-1);
		assertEquals(-1, application.performSubtraction(2, -3));
	}

	@Test
	public void testPerformMultiplicationWithTwoNegativeIntegers() {
		when(service.multiplication(-8, -2)).thenReturn(16);
		assertEquals(16, application.performMultiplication(-8, -2));
	}

	@Test
	public void testPerformMultiplicationWithTwoPositiveIntegers() {
		when(service.multiplication(8, 6)).thenReturn(48);
		assertEquals(48, application.performMultiplication(8, 6));
	}

	@Test
	public void testPerformMultiplicationWithOnePositiveOneNegativeIntegers() {
		when(service.multiplication(2, -3)).thenReturn(-6);
		assertEquals(-6, application.performMultiplication(2, -3));
	}

	@Test
	public void testPerformDivisionWithTwoNegativeIntegers() {
		when(service.multiplication(-8, -2)).thenReturn(4);
		assertEquals(4, application.performMultiplication(-8, -2));
	}

	@Test
	public void testPerformDivisionWithTwoPositiveIntegers() {
		when(service.multiplication(8, 6)).thenReturn(48);
		assertEquals(48, application.performMultiplication(8, 6));
	}

	@Test
	public void testPerformDivisionWithOnePositiveOneNegativeIntegers() {
		when(service.multiplication(12, -3)).thenReturn(-4);
		assertEquals(-4, application.performMultiplication(12, -3));
	}
	
	
	@Test(expected= ArithmeticException.class)
	public void testPerformDivisionByZero() {
		doThrow(new ArithmeticException("dif")).when(service).division(10, 0);
		application.performDivision(10, 0);
	}


	@Test(expected =NegativeNumberException.class)
	public void testPerformFactorialWithNegativeNumber() throws NegativeNumberException {
	doThrow(new NegativeNumberException("Negative number")).when(service).factorial(-5);
	application.findFactorial(-5);
	}

	
	
	
	@Test
	public void testFindFactorialWithPositiveInteger() throws NegativeNumberException
	{
		when(service.factorial(5)).thenReturn(120L);
		assertEquals(120,application.findFactorial(5));
	}
	
	@Test
	public void testfindSquareWithOnePositive()
	{
		when(service.square(4)).thenReturn(16L);
		assertEquals(16, service.square(4));
	}
	
	@Test
	public void testfindSquareWithOneNegative()
	{
		when(service.square(-4)).thenReturn(16L);
		assertEquals(16, service.square(-4));
	}
	

	
	
	
}
