package Tests;

import static org.junit.Assert.*;
import calculator.*;

import org.junit.Assert;
import org.junit.Test;

public class Constructor {

	@Test
	public void shouldCreateInstance() 
	{
		Calculator c = new Calculator();
		
		Assert.assertEquals(true,c instanceof Calculator);
	}

	
	@Test
	public void sumTest()
	{
		Assert.assertEquals(6, 3+3);
		Assert.assertEquals(-6, 3-9);
		Assert.assertEquals(6, -12+18);
		Assert.assertEquals(0, 0);
	}
	
	
}
