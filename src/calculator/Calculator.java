package calculator;

public class Calculator 
{
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
	
	//js222xt
	public double recArea(double length, double hight) {
		return multiply(length, hight);
	}

	//js222xt
	public double triC(double a, double b) {
		double res = Math.sqrt( Math.pow(a, 2) + Math.pow(b, 2) );
		if(!Double.isInfinite(res)){
			return res;
		}
		else{
			throw new RuntimeException("Double is Infinite");
		}
	}
	
}
