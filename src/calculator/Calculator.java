package calculator;

public class Calculator 
{
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

	public double sub(double a, double b) {
		double res = a - b;
		if(!Double.isInfinite(res)){
			return res;
		}
		else{
			throw new RuntimeException("Double is Infinite");
		}
	}

	public double recArea(double length, double hight) {
		return multiply(length, hight);
	}
	
}
