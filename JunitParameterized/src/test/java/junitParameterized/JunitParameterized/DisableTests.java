package junitParameterized.JunitParameterized;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DisableTests
{

	@BeforeEach
	void setUp() throws Exception
	{
	}

	@Disabled(value = "not executing as may not required now")
	@Test
	void test()
	{
		fail("Not yet implemented");
	}

}
