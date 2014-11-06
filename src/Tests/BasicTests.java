package Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({})
public class BasicTests {

	SuperCalculator c;
	
	@Before
	public void shouldCreateInstance(){
		c = new SuperCalculator();
	}
}
