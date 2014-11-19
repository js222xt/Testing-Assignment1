package calculator;

import java.util.Scanner;

public class MainCalculator 
{
	public static void main(String[] args) 
	{
		Calculator calc = new Calculator();
		String inputFromUser = "", result = "";
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Calculator. \nType divide, add, substract or multiply: ");
		// Läser in från användaren
		inputFromUser = scanner.nextLine();
		
		if (inputFromUser.contains("divide"))
		{
			
		}
		else if (inputFromUser.contains("add"))
		{
			
		}
		else if (inputFromUser.contains("substract"))
		{
			
		}
		else if (inputFromUser.contains("multiply"))
		{
			
		}
	
	}
	

}
