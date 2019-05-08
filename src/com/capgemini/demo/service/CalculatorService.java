package com.capgemini.demo.service;

import com.capgemini.demo.Exception.NegativeNumberException;

public interface CalculatorService {

	public int addition(int number1,int number2);
	public int subtraction(int number1,int number2);
	public int multiplication(int number1,int number2);
	public int division(int number1,int number2);
	public long factorial(int number) throws NegativeNumberException;
	public long square(int number);

	
}
