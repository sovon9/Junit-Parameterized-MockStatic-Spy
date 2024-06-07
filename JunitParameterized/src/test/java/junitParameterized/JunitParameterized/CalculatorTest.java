package junitParameterized.JunitParameterized;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest
{
	Calculator calculator;
	@BeforeEach
	void setUp() throws Exception
	{
		calculator = new CalculatorImpl();
	}
	
	public static Stream<Integer> oneArgValueProvider()
	{
		return Stream.of(4,2,6);
	}
	
	public static Stream<Arguments> multiArgValueProvider()
	{
		return Stream.of(Arguments.arguments(1,2,3),
				Arguments.arguments(2,2,4),
				Arguments.arguments(2,4,6)
				);
	}
	
	@ParameterizedTest
	@MethodSource("multiArgValueProvider")
	void testCalculator(int a, int b, int c)
	{
		assertEquals(c, calculator.add(a, b),"sum of values not matching");
	}
	
	@ParameterizedTest
	@ValueSource(ints = {4 ,2 ,6})
	void testEven(int num)
	{
		assertTrue(calculator.even(num));
	}
	
	@ParameterizedTest
	@MethodSource("oneArgValueProvider")
	void testEvenWithMethodSource(int num)
	{
		assertTrue(calculator.even(num));
	}
	

}
