package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import calculator.*;

public class Constructor {

	@Test
	public Calculator shouldCreateInstance() {
		return new Calculator();
	}

}
