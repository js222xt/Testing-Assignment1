package calculator;

public class Calculator 
{
	/**
	 * Adds two numbers - rj222dq
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
	 * Divide to numbers - rj222dq
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
	
	
	//js222xt
	public double multiply(double a, double b){
		try{
			double res = a * b;
			if(!Double.isInfinite(res)){
				return res;
			}
			else{
				throw new RuntimeException("Double is Infinite");
			}			
		}
		catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}		
	}

	//js222xt
	public double sub(double a, double b) {
		double res = a - b;
		if(!Double.isInfinite(res)){
			return res;
		}
		else{
			throw new RuntimeException("Double is Infinite");
		}
	}
	
}
