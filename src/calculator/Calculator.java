package calculator;

public class Calculator 
{
	/**
	 * Adds two numbers 
	 * @param num1 number 1
	 * @param num2 number 2
	 * @return result of adding the two numbers
	 * @throws Exception 
	 */
	public double add(double num1, double num2) throws Exception
	{
		try
		{
			double result = num1 + num2;
			if (!Double.isInfinite(result))
			{ 
				return num1 + num2;
			}
		}
		catch (Exception ex)
		{
			System.out.println("Error: " + ex.toString());
		}
		throw new Exception("Error.");
	}
	
	/**
	 * Divide to numbers
	 * @param numerator
	 * @param denominator
	 * @return result
	 */
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
	
}
