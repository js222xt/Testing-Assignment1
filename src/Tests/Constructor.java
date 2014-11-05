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

}
