package Tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import calculator.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Constructor {
	Calculator c;
	
	@Before
	public void Constructor()
	{
		c = new Calculator();
	}

	@Test
	public void shouldCreateInstance() 
	{		
		Assert.assertEquals(true, c instanceof Calculator);
	}


	@Test (expected=Error.class)
	public void overloadMultiply()
	{
		Assert.assertEquals(true, c.multiply(2147483647, 2));
	}
	
	@Test
	public void shouldMultiply()
	{		
		Assert.assertEquals(25, 25, c.multiply(5,5));
	}

	@Test (expected=Error.class)
	public void overloadAdd()
	{
		Assert.assertEquals(true, c.add(2147483647, 2));
	}
	
	@Test
	public void sumTest()
	{
		Assert.assertEquals(6, 6, c.add(3,3));
		Assert.assertEquals(12, 6, c.add(3,9));
		Assert.assertEquals(6, 6, c.add(-12,18));
		Assert.assertEquals(0, 0, c.add(0, 0));
	}
	
	@Test (expected=Error.class)
	public void overloadSubtract()
	{
		Assert.assertEquals(true, c.divide(2, 9));
	}
	
	@Test
	public void DivideTest()
	{
		Assert.assertEquals(6, 6, c.divide(36,6));
		Assert.assertEquals(12, 12, c.divide(120,10));
		Assert.assertEquals(5, 5, c.divide(0, 5));
	}
	
	
	
	
}
