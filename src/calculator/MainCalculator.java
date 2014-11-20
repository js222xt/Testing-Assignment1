package calculator;

import java.util.List;
import java.util.Scanner;

public class MainCalculator 
{
	public static void main(String[] args) {
		Calculator calc = new Calculator();

		Scanner scanner = new Scanner(System.in);
		String quitS = "Q";
		String preresult = "P";
		boolean quit = false;
		while(!quit){
			System.out.print("\nCalculator. Choose\n1 = divide\n2 = add\n3 = substract\n4 = multiply\n"
					+ "5 = Area of rectangle \n6 = Pythagoras Guy Load \n'"+ quitS+"'to quit\n'"+preresult+"' "
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
						List<String> results = calc.getResults();
						System.out.println("\nPrevious results:");
						for (String string : results) {
							System.out.println(string);
						}
						System.out.println("Enter Choise\n:");
					}
					else{
						int chose = Integer.valueOf(s); 
						if(chose == 1 || chose == 2 || chose == 3 || chose == 4 || chose == 5 || chose == 6){
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
				}
			}
			boolean isDouble = false;
			switch (type) {
			case 1:
				System.out.print("Divide:\nEnter first number:");
				double numerator = 0;
				
				while(!isDouble){
					try{
						numerator = Double.valueOf(scanner.nextLine());
						isDouble = true;
					}
					catch(Exception e){
						numerator = 0;
						System.out.println("Not double, try again\n:");
					}
				}
				System.out.print("Enter second number(!= 0):");
				double denominator = 0;
				isDouble = false;
				while(!isDouble){
					try{
						denominator = Double.valueOf(scanner.nextLine());
						if(denominator == 0){
							throw new Exception();
						}
						isDouble = true;
					}
					catch(Exception e){
						denominator = 0;
						System.out.println("Not double or 0, try again\n:");
					}
				}
				System.out.println("Result: " + calc.divide(numerator, denominator));
				isDouble = false;
				break;
			case 2:
				System.out.print("Add:\nEnter first number:");
				double a1 = 0;
				isDouble = false;
				while(!isDouble){
					try{
						a1 = Double.valueOf(scanner.nextLine());
						isDouble = true;
					}
					catch(Exception e){
						a1 = 0;
						System.out.println("Not double, try again\n:");
					}
				}
				System.out.print("Enter second number:");
				double a2 = 0;
				isDouble = false;
				while(!isDouble){
					try{
						a2 = Double.valueOf(scanner.nextLine());
						if(a2 == 0){
							throw new Exception();
						}
						isDouble = true;
					}
					catch(Exception e){
						a2 = 0;
						System.out.println("Not double or 0, try again\n:");
					}
				}
				try {
					System.out.println("Result: " + calc.add(a1, a2));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 3:
				System.out.print("Substraction:\nEnter first number(double):");
				double s1 = 0;
				isDouble = false;
				while(!isDouble){
					try{
						s1 = Double.valueOf(scanner.nextLine());
						isDouble = true;
					}
					catch(Exception e){
						s1 = 0;
						System.out.println("Not double, try again\n:");
					}
				}
				System.out.print("Enter second number(double and != 0):");
				double s2 = 0;
				isDouble = false;
				while(!isDouble){
					try{
						s2 = Double.valueOf(scanner.nextLine());
						isDouble = true;
					}
					catch(Exception e){
						s2 = 0;
						System.out.println("Not double, try again\n:");
					}
				}
				System.out.println("Result: " + calc.sub(s1, s2));
				break;
			case 4:			
				System.out.print("Multiply:\nEnter first number(double):");
				double m1 = 0;
				isDouble = false;
				while(!isDouble){
					try{
						m1 = Double.valueOf(scanner.nextLine());
						isDouble = true;
					}
					catch(Exception e){
						m1 = 0;
						System.out.println("Not double, try again\n:");
					}
				}
				System.out.print("Enter second number(double and != 0):");
				double m2 = 0;
				isDouble = false;
				while(!isDouble){
					try{
						m2 = Double.valueOf(scanner.nextLine());
						isDouble = true;
					}
					catch(Exception e){
						m2 = 0;
						System.out.println("Not double or 0, try again\n:");
					}
				}
				System.out.println("Result: " + calc.multiply(m1, m2));
				break;
			case 5:			
				System.out.print("Area:\nEnter first number(double):");
				double r1 = 0;
				isDouble = false;
				while(!isDouble){
					try{
						r1 = Double.valueOf(scanner.nextLine());
						isDouble = true;
					}
					catch(Exception e){
						r1 = 0;
						System.out.println("Not double, try again\n:");
					}
				}
				System.out.print("Enter second number(double and != 0):");
				double r2 = 0;
				isDouble = false;
				while(!isDouble){
					try{
						r2 = Double.valueOf(scanner.nextLine());
						isDouble = true;
					}
					catch(Exception e){
						r2 = 0;
						System.out.println("Not double or 0, try again\n:");
					}
				}
				System.out.println("Result: " + calc.recArea(r1, r2));
				break;
			case 6:			
				System.out.print("Load:\nEnter first number(double):");
				double p1 = 0;
				isDouble = false;
				while(!isDouble){
					try{
						p1 = Double.valueOf(scanner.nextLine());
						isDouble = true;
					}
					catch(Exception e){
						p1 = 0;
						System.out.println("Not double, try again\n:");
					}
				}
				System.out.print("Enter second number(double and != 0):");
				double p2 = 0;
				isDouble = false;
				while(!isDouble){
					try{
						p2 = Double.valueOf(scanner.nextLine());
						isDouble = true;
					}
					catch(Exception e){
						p2 = 0;
						System.out.println("Not double or 0, try again\n:");
					}
				}
				System.out.println("Result: " + calc.triC(p1,p2));
				break;
			}
		}
	
	}
}
