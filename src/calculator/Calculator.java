package calculator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Calculator 
{
	List<String>  results = new ArrayList<String>();
	private String filename = "results.benja";
	
	public Calculator(){
		readFromDisk();
	}
	
	private void saveResult(String res){
		results.add(res);
		saveToDisk();
	}
	
	private void saveToDisk(){
		// Save to disk
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream(filename));
		    out.writeObject(results);
		    out.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	private void readFromDisk(){
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(new FileInputStream(filename));
		    try {
				results = (List<String>) in.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    in.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	public List<String> getResults(){
		return results;
	}
	
	
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
				saveResult("Add: " + num1 + "+" + num2 +" = " + result);
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
			double result = numerator/denominator;
			saveResult("Divide: " + numerator + "/" + denominator +" = " + result);
			
			return result;
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
					saveResult("Multiply: " + a + "*" + b +" = " + res);
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
	public double recArea(double length, double hight) {
		double res = multiply(length, hight);
		saveResult("Area: " + length + " " + hight +" = " + res);
		return res;
	}

	//js222xt
	public double sub(double a, double b) {
		double res = a - b;
		if(!Double.isInfinite(res)){
			saveResult("Substraction: " + a + "-" + b +" = " + res);
			return res;
		}
		else{
			throw new RuntimeException("Double is Infinite");
		}
	}
	
	//js222xt
	public double triC(double a, double b) {
		double res = Math.sqrt( Math.pow(a, 2) + Math.pow(b, 2) );
		if(!Double.isInfinite(res)){
			saveResult("Pythagoras: " + a + " " + b +" = " + res);
			return res;
		}
		else{
			throw new RuntimeException("Double is Infinite");
		}
	}
}
