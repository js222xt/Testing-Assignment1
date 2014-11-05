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
	public void shouldMultiply()
	{
		Calculator c  = new  Calculator();
		
		Assert.assertArrayEquals(25, c.multiply(5,5));
	}

}
