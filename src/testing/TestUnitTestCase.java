package testing;

import static org.junit.Assert.*;

import org.junit.Assert;
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

	@Test (expected=Error.class)
	public void overloadAdd() throws Exception
	{ 
		c.add(Double.MAX_VALUE, Double.MAX_VALUE);
	}
	
	@SuppressWarnings("deprecation")
	@Test 
	public void addnumbers() throws Exception
	{
		assertEquals(4.50, c.add(2.25, 2.25), 0);

		assertEquals(10.25, c.add(5.125, 5.125), 0);

		assertEquals(10.5, c.add(5, 5.5), 0);

	}
	

	
}
