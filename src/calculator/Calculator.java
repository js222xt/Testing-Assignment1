package calculator;

public class Calculator 
{

	public double multiply(double a, double b)
	{
		try
		{
			return a * b;
		}
		catch (Exception e)
		{
			throw new RuntimeException("Error: " + e.toString());
		}
	}
	
	public int multiplyInt(int a, int b){
		return a * b;
	}
	

	
	public double add(double num1, double num2)
	{
		try
		{
			return num1 + num2;
		}
		catch (Exception e)
		{
			throw new RuntimeException("Error: " + e.toString());
		}
	}
	
	
	public double divide(double numerator, double denominator)
	{
		try
		{ 
			if (denominator == 0)
			{
				throw new RuntimeException("Denominator is zero!");
			}
			return numerator/denominator;
		}
		catch (Exception e)
		{
			throw new RuntimeException("Error: " + e.toString());
		}
	}



	public float multiplyFloat(double d, double e) {
		return (float) (d * e);
	}
	
}
