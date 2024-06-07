package junitParameterized.mockStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MockStaticTest
{

	@BeforeEach
	void setUp() throws Exception
	{
	}

	@Test
	void testCreateNewUser()
	{
		CreateUser user = new CreateUser();
		// mocking the static method
		mockStatic(IDGenerator.class);
		// then using when and then the way we use  for normal mock
		when(IDGenerator.generate()).thenReturn(2);
		User createUser = user.createUser(new User("ss"));
		assertEquals(2, createUser.getId());
	}

}
