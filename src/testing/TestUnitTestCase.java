package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calculator.Calculator;

public class TestUnitTestCase {

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

	@Test
	public void shouldMultiply(){
		double delta = 0;
		assertEquals(10.0, c.multiply(2.0,5.0), delta);
		assertEquals(-10.0, c.multiply(2.0,-5.0), delta);
		assertEquals(0.0, c.multiply(-2.0,0.0), delta);
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionMultiply(){
		c.multiply(Double.MAX_VALUE,5.0);
	}
	
	@Test
	public void shouldSubstractPositive(){
		double delta = 0;
		assertEquals(10.0, c.sub(15.0,5.0), delta);
	}
	
	@Test
	public void shouldSubstractNegative(){
		double delta = 0;
		assertEquals(-10.0, c.sub(0.0,10.0), delta);
	}
	
}
