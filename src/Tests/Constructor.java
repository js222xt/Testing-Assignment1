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
	public void shouldMultiplyInt()
	{		
		Assert.assertEquals(25, 25, c.multiply(5,5));
		Assert.assertEquals(25, c.multiplyInt(5,5));
		Assert.assertEquals(0, c.multiplyInt(0,5));
		Assert.assertEquals(0, c.multiplyInt(5,0));
		Assert.assertEquals(0, c.multiplyInt(0,0));
	}
	
	@Test
	public void shouldMultiplyFLoat()
	{		
		float delta = 0;
		Assert.assertEquals(25.0f, c.multiplyFloat(5.0f,5.0f), delta);
		Assert.assertEquals(11.0f, c.multiplyFloat(5.5f,2.0f), delta);
		Assert.assertEquals(30.802502f, c.multiplyFloat(5.55f,5.55f), delta);
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
