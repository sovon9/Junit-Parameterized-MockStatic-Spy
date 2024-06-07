package junitParameterized.JunitParameterized;


public class CalculatorImpl implements Calculator {

	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public boolean even(int num)
	{
		return num%2==0;
	}

}
