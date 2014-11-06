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
			else
			{
				throw new Error("Error.");
			}
		}
		catch (Exception ex)
		{
			System.out.println("Error: " + ex.toString());
		}
		throw new Exception("Error.");
	}
}
