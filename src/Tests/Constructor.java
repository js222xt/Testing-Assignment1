package Tests;

import static org.junit.Assert.*;
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

	
	@Test
	public void sumTest()
	{
		Assert.assertEquals(6, c.add(3,3));
		Assert.assertEquals(12, c.add(3,9));
		Assert.assertEquals(6, c.add(-12,18));
		Assert.assertEquals(0, c.add(0, 0));
	}
	
	
}
