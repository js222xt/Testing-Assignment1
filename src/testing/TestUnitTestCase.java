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
	}
	
}
