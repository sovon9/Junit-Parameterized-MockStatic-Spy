package junitParameterized.spy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class SpyTest
{

	@Spy // partial mocking
	List<String> data = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception
	{
		MockitoAnnotations.openMocks(this);
	}

	/*
	 * without stubbing any operation, using real implementations of List
	 */
	@Test
	void testHappyFlow()
	{
		boolean isDuplicate = false;
		List<String> finalData = new ArrayList<>();
		data.add("ss");
		data.add("guddu");
		for(int i=0; i<data.size(); i++)
		{
			String string = data.get(i);
			isDuplicate = finalData.stream().anyMatch((s)->{
				return s.equals(string);
			});
			if(isDuplicate)
			{
				break;
			}
			finalData.add(string);
		}
		assertFalse(isDuplicate);
	}
	
	/*
	 * here stubbing a specific value for to return duplicate value
	 * and returns isDuplicate true
	 */
	@Test
	void testUnhappyFlow()
	{
		boolean isDuplicate = false;
		List<String> finalData = new ArrayList<>();
		// stubbing get(1) call to return "ss" again
		doReturn("ss").when(data).get(1);
		
		data.add("ss");
		data.add("guddu");
		for(int i=0; i<data.size(); i++)
		{
			String string = data.get(i);
			System.out.println(string);
			isDuplicate = finalData.stream().anyMatch((s)->{
				return s.equals(string);
			});
			if(isDuplicate)
			{
				break;
			}
			finalData.add(string);
		}
		assertTrue(isDuplicate);
	}

}
