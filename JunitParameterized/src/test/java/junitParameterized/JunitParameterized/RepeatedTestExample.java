package junitParameterized.JunitParameterized;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RepeatedTestExample
{
	Calculator calculator;
	@BeforeEach
	void setUp() throws Exception
	{
		System.out.println("before each test....");
		calculator = new CalculatorImpl();
	}

	@RepeatedTest(5)
	void test()
	{
		calculator.add(2, 2);
	}
	
	@AfterEach
	void end()
	{
		System.out.println("after each test....");
	}

}
