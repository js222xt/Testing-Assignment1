package testing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;
import calculator.CalculatorManager;
import calculator.SaveManager;

public class TestUnitTestCase 
{
	private Calculator c;
	private CalculatorManager calcMngr;
	
	// Reflection
	private Method m;
    private Class[] parameterTypes;
    private Object[] parameters;

	@Before
	public void initiate() throws Exception
	{
		c = new Calculator();
		calcMngr = new CalculatorManager(new SaveManager("results.benja"));
	}
	
	// Testar Calculator-klassen
	// rj222dq
	@Test 
	public void shouldCreateInstance()
	{
		assertTrue(c instanceof Calculator);
	}

	// rj222dq
	@Test (expected=Exception.class)
	public void overloadAdd() throws Exception
	{ 
		c.add(Double.MAX_VALUE, Double.MAX_VALUE);
	}
	
	// rj222dq
	@Test 
	public void addnumbers() throws Exception
	{
		assertEquals(4.50, c.add(2.25, 2.25), 0); 
		assertEquals(10.25, c.add(5.125, 5.125), 0); 
		assertEquals(10.5, c.add(5, 5.5), 0);
		assertEquals(-10, c.add(-5, -5), 0);
	}
	
	// rj222dq
	@Test (expected=Error.class)
	public void overloadSubtract()
	{
		Assert.assertEquals(true, c.divide(2, 9));
	}
	
	// rj222dq
	@Test
	public void DivideTest()
	{
		Assert.assertEquals(-6, -6, c.divide(-36,6));
		Assert.assertEquals(6, 6, c.divide(36,6));
		Assert.assertEquals(12, 12, c.divide(120,10));
		Assert.assertEquals(5, 5, c.divide(0, 5));
	}
	
	// rj222dq
	@Test (expected=Exception.class)
	public void divideDeminatorZero() throws Exception
	{
		c.divide(2, 0);
	}

	// rj222dq
	@Test
	public void pyth()
	{
		Assert.assertEquals(5, c.pyth(3, 4), 0);
	}
	
	// rj222dq
	@Test (expected=RuntimeException.class)
	public void pythExeception()
	{
		Assert.assertEquals(5, c.pyth(Double.MAX_VALUE +2, 4), 0);
	}
	
	//js222xt
	@Test
	public void shouldMultiply(){
		double delta = 0;
		assertEquals(10.0, c.multiply(2.0,5.0), delta);
		assertEquals(-10.0, c.multiply(2.0,-5.0), delta);
		assertEquals(0.0, c.multiply(-2.0,0.0), delta);
	}
	
	//js222xt
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionMultiply(){
		c.multiply(Double.MAX_VALUE,5.0);
	}
	
	//js222xt
	@Test
	public void shouldSubstractPositive(){
		double delta = 0;
		assertEquals(10.0, c.sub(15.0,5.0), delta);
	}
	
	//js222xt
	@Test
	public void shouldSubstractNegative(){
		double delta = 0;
		assertEquals(-10.0, c.sub(0.0,10.0), delta);
	}
	
	//js222xt
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionSub(){
		c.sub(Double.MIN_VALUE,Double.NEGATIVE_INFINITY);
	}
	
	
	// Testar CalculatorManager-klassen
	
	@Test
	public void testSaveResult() throws Exception
	{
		// reflection
		parameterTypes = new Class[1];
        parameterTypes[0] = java.lang.String.class;
        m = calcMngr.getClass().getDeclaredMethod("saveResult", parameterTypes);
        m.setAccessible(true);
        parameters = new Object[1];
        
		parameters[0] = "test";
        m.invoke(calcMngr, parameters);  
	}
	
	@Test
	public void testSaveResultException() throws Exception
	{ 
        CalculatorManager calcMngrErrorObj = new CalculatorManager(new SaveManager("¤%&/error"));
        Field privateStringField = CalculatorManager.class.getDeclaredField("filename");
        privateStringField.setAccessible(true);
        String fieldValue = (String) privateStringField.get(calcMngrErrorObj);
        
		// reflection
		parameterTypes = new Class[1];
        parameterTypes[0] = java.lang.String.class;
        m = calcMngr.getClass().getDeclaredMethod("saveResult", parameterTypes);
        m.setAccessible(true);
        parameters = new Object[1];
        
		parameters[0] = "test";
        m.invoke(calcMngr, parameters);  
	}
	
	@Test
	public void testReadNumbersAndGetDouble() throws Exception
	{
		// reflection
		parameterTypes = new Class[1];
        parameterTypes[0] = java.util.Scanner.class;
        // calculator.CalculatorManager.getDouble(java.util.Scanner, java.lang.Boolean)
        m = calcMngr.getClass().getDeclaredMethod("readNumbers", parameterTypes);
        m.setAccessible(true);
        parameters = new Object[1];
        
		parameters[0] = new Scanner(System.in);
		m.invoke(calcMngr, parameters);		
	}
	
	@Test 
	public void testCalculateException()
	{
		calcMngr.calculate("jjkkj");
	}
	
	@Test 
	public void testCalculateDivide() throws Exception
	{
		Field num1 = calcMngr.getClass().getDeclaredField("num1");
		num1.setAccessible(true);
		num1.set(calcMngr, 2);
		Field num2 = calcMngr.getClass().getDeclaredField("num2");
		num2.setAccessible(true);
		num2.set(calcMngr, 2);
		double result = (double) calcMngr.calculate("divide");
		assertEquals(1, result, 0);
	}
	
	@Test 
	public void testCalculateMultiply() throws Exception
	{
		Field num1 = calcMngr.getClass().getDeclaredField("num1");
		num1.setAccessible(true);
		num1.set(calcMngr, 2);
		Field num2 = calcMngr.getClass().getDeclaredField("num2");
		num2.setAccessible(true);
		num2.set(calcMngr, 2);
		double result = (double) calcMngr.calculate("multiply");
		assertEquals(4, result, 0);
	}
	
	@Test 
	public void testCalculateAdd() throws Exception
	{
		Field num1 = calcMngr.getClass().getDeclaredField("num1");
		num1.setAccessible(true);
		num1.set(calcMngr, 2);
		Field num2 = calcMngr.getClass().getDeclaredField("num2");
		num2.setAccessible(true);
		num2.set(calcMngr, 2);
		double result = (double) calcMngr.calculate("add");
		assertEquals(4, result, 0);
	}
	
	@Test 
	public void testCalculateSub() throws Exception
	{
		Field num1 = calcMngr.getClass().getDeclaredField("num1");
		num1.setAccessible(true);
		num1.set(calcMngr, 2);
		Field num2 = calcMngr.getClass().getDeclaredField("num2");
		num2.setAccessible(true);
		num2.set(calcMngr, 2);
		double result = (double) calcMngr.calculate("sub");
		assertEquals(0, result, 0);
	}
	
	@Test 
	public void testCalculatePyth() throws Exception
	{
		Field num1 = calcMngr.getClass().getDeclaredField("num1");
		num1.setAccessible(true);
		num1.set(calcMngr, 3);
		Field num2 = calcMngr.getClass().getDeclaredField("num2");
		num2.setAccessible(true);
		num2.set(calcMngr, 4);
		double result = (double) calcMngr.calculate("pyth");
		assertEquals(5, result, 0);
	}
	
	
	@Test 
	public void testStart()
	{
		calcMngr.start();
	}
	
}
