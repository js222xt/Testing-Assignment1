package calculator;


/**
 * S�tter i g�ng kalkylatorn.
 * @author rj222dq
 *
 */
public class MainCalculator 
{
	public static void main(String[] args) 
	{
		SaveManager sm = new SaveManager();
		CalculatorManager calc = new CalculatorManager(sm, "results.benja");
		calc.start();
	}
}
