package calculator;

import java.io.FileInputStream; 
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Syftet med klassen är att hantera "Calculator"-klassen.
 * @author rj222dq
 *
 */
public class CalculatorManager 
{
	private Calculator calc;
	private List<String> results;
	private String filename;
	private double num1, num2;
	
	/**
	 * Konstruktor
	 */
	public CalculatorManager(String filename)
	{
		calc = new Calculator();
		this.filename = filename;
		results = new ArrayList<String>();
		num1 = 0;
		num2 = 0;
		readFromDisk();
	}
	
	/**
	 * Spara resultatet
	 * @param saveStr Resultat att spara i form av en sträng
	 */
	private void saveResult(String saveStr)
	{
		// Skriver ut till användaren
		System.out.println(saveStr);
		// Lägger till strängen till listan
		results.add(saveStr);
		// Sparar strängen till fil
		saveToDisk();
	}
	

	/**
	 * Läs sparad data från fil.
	 */
	private void readFromDisk()
	{
		try 
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			results = (List<String>) in.readObject();
		    in.close();
		}
	    catch (Exception ex) 
	    {
			System.out.println("Error: " + ex.toString());
		}
	}
	
	/**
	 * Spara listan med information till fil.
	 */
	private void saveToDisk()
	{
		try 
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
		    out.writeObject(results);
		    out.close();
		} 
		catch (Exception ex) 
		{
			System.out.println("Error: " + ex.toString());
		}
	}
	
	/**
	 * Räknar ut det användaren vill.
	 * @param method Sträng som innehåller metodval.
	 * @param num1 Nummer 1.
	 * @param num2 Nummer 2.
	 * @return Resultatet.
	 */
	public double calculate(String method)
	{
		double result = 0;
		try
		{ 
			if (method.equals("divide"))
			{
				result = calc.divide(num1, num2);
				saveResult("Divide: " + num1 + "/" + num2 +" = " + result);
			}
			else if (method.equals("multiply"))
			{
				result = calc.multiply(num1, num2);
				saveResult("Multiply: " + num1 + "*" + num2 +" = " + result);
			}
			else if (method.equals("add"))
			{
				result = calc.add(num1, num2);
				saveResult("Add: " + num1 + "+" + num2 +" = " + result);
			}
			else if (method.equals("sub"))
			{
				result = calc.sub(num1, num2);
				saveResult("Substraction: " + num1 + "-" + num2 +" = " + result);
			}
			else if (method.equals("pyth"))
			{
				result = calc.pyth(num1, num2);
				saveResult("Pythagoras: " + num1 + " " + num2 +" = " + result);
			}
			else
			{
				throw new RuntimeException("Error. No such method for calculate.");
			}
		}
		catch (Exception ex) 
		{
			System.out.println("Error: " + ex.toString());
		}
		return result;
	}
	
	
	
	public void start()
	{

		Scanner scanner = new Scanner(System.in);
		String quitS = "Q";
		String preresult = "P";
		boolean quit = false;
		while(!quit){
			System.out.print("\nCalculator. Choose\n1 = divide\n2 = add\n3 = substract\n4 = multiply\n"
					+ "5 = Pythagoras Guy Load \n'"+ quitS+"'to quit\n'"+preresult+"' "
							+ "to see previous results: ");
			// Läser in från användaren
			
			boolean isInt = false;
			int type = 0;
			while(!isInt){
				try{
					String s = scanner.nextLine();
					if(s.toUpperCase().matches(quitS)){
						quit = true;
						return;
					}
					else if(s.toUpperCase().matches(preresult)){
						System.out.println("\nPrevious results:");
						for (String string : results) {
							System.out.println(string);
						}
						System.out.println("Enter Choise\n:");
					}
					else{
						int chose = Integer.valueOf(s); 
						if(chose == 1 || chose == 2 || chose == 3 || chose == 4 || chose == 5){
							type = chose;
							isInt = true;
						}
						else{
							throw new Exception();
						}
					}					
				}
				catch(Exception e){
					System.out.println("Not in range, try again\n:");
					System.out.println("Error: " + e.toString());
				}
			}
			// Läser in nummer från användaren
			readNumbers(scanner); 
			
			switch (type) {
			case 1:
				calculate("divide");
				break;
			case 2:
				calculate("add");
				break;
			case 3:
				calculate("sub");
				break;
			case 4:			
				calculate("multiply");
				break;
			case 5:	
				calculate("pyth");
				break;
			}
		}
	}

	/**
	 * Läser in nummer från användaren.
	 * @param scanner Scannerobjekt
	 */
	private void readNumbers(Scanner scanner) 
	{
		System.out.print("\n"+"Enter first number:");
		num1 = getDouble(scanner);
		
		System.out.print("Enter second number:");
		num2 = getDouble(scanner); 
	}
	
	private double getDouble(Scanner scanner) {
		double p1 = 0;
		boolean isDouble = false;
		while(!isDouble){
			try{
				p1 = Double.valueOf(scanner.nextLine());
				isDouble = true;
			}
			catch(Exception e){
				p1 = 0;
				System.out.println("Not double, try again\n:");
				System.out.println("Error: " + e.toString());
			}
		}
		return p1;
	}

	


}
