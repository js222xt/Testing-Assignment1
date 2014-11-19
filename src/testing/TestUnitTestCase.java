package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import calculator.Calculator;


public class TestUnitTestCase {

	private Calculator c;
	private Calculator cMock = mock(Calculator.class);
	
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
	
	//js222xt
	@Test
	public void shouldGetRectangleArea(){
		double delta = 0;
		assertEquals(25, c.recArea(5.0,5.0), delta);
	}
	
	//js222xt
	@Test
	public void shouldGetRectangleC(){
		double delta = 0.01;
		assertEquals(5.0, c.triC(3.0,4.0), delta);
	}
	
	//js222xt
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionTriC(){
		c.triC(Double.MAX_VALUE,4.0);
	}

}
