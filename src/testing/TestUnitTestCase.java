package testing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class TestUnitTestCase 
{

	private Calculator c;

	@Before
	public void initiate()
	{
		c = new Calculator();
	}
	
	@Test 
	public void shouldCreateInstance()
	{
		assertTrue(c instanceof Calculator);
	}

	@Test (expected=Error.class)
	public void overloadAdd() throws Exception
	{ 
		c.add(Double.MAX_VALUE, Double.MAX_VALUE);
	}
	
	@Test 
	public void addnumbers() throws Exception
	{
		assertEquals(4.50, c.add(2.25, 2.25), 0); 
		assertEquals(10.25, c.add(5.125, 5.125), 0); 
		assertEquals(10.5, c.add(5, 5.5), 0);
		assertEquals(-10, c.add(-5, -5), 0);
	}
	
	@Test (expected=Error.class)
	public void overloadSubtract()
	{
		Assert.assertEquals(true, c.divide(2, 9));
	}
	
	@Test
	public void DivideTest()
	{
		Assert.assertEquals(-6, -6, c.divide(-36,6));
		Assert.assertEquals(6, 6, c.divide(36,6));
		Assert.assertEquals(12, 12, c.divide(120,10));
		Assert.assertEquals(5, 5, c.divide(0, 5));
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
	

	
}
