package com.api.asserts;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.api.reporterConfig.LogStatus;



public class Assert 
{
	public static void pass(Object actual, Object expected, String message)
	{
		if(message==null)
		{
			LogStatus.pass("Expected result: "+expected+" actual result: "+actual);
		}
		else
		{
			LogStatus.pass(message+" :Expected result: "+expected+" actual result: "+actual);
		}
	}
	
	public static void pass(Object[] actual, Object[] expected, String message)
	{
		if(message==null)
		{
			LogStatus.pass("Expected result: "+Arrays.toString(expected)+" actual result: "+Arrays.toString(actual));
		}
		else
		{
			LogStatus.pass(message+" :Expected result: "+Arrays.toString(expected)+" actual result: "+Arrays.toString(actual));
		}
	}
	
	public static void assertEquals(boolean actual, boolean expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected);
			pass(actual, expected, null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
			
		}
	}
	
	public static void assertEquals(boolean actual, boolean expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected,message);
			pass(actual, expected, message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
			
		}
	}
	
	public static void assertEquals(byte[] actual, byte[] expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected);
			pass(actual,expected,null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(byte[] actual, byte[] expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected,message);
			pass(actual,expected,message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(byte actual, byte expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected);
			pass(actual, expected, null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(byte actual, byte expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected,message);
			pass(actual, expected, message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(char actual, char expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected);
			pass(actual, expected, null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(char actual, char expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected,message);
			pass(actual, expected, message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(Collection<?> actual, Collection<?> expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected);
			pass(actual, expected, null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(Collection<?> actual, Collection<?> expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected,message);
			pass(actual, expected, message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	public static void assertEquals(Double[] actual, Double[] expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected);;
			pass(actual,expected,null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(Double[] actual, Double[] expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected, message);
			pass(actual,expected,message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(Object actual, Object expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected);
			pass(actual, expected, null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(Object actual, Object expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected,message);
			pass(actual, expected, message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	
	public static void assertEquals(int actual, int expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected);
			pass(actual, expected, null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(int actual, int expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected,message);
			pass(actual, expected, message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(Iterable<?> actual, Iterable<?> expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected);
			pass(actual, expected, null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(Iterable<?> actual, Iterable<?> expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected,message);
			pass(actual, expected, message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(Iterator<?> actual, Iterator<?> expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected);
			pass(actual, expected, null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(Iterator<?> actual, Iterator<?> expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected,message);
			pass(actual, expected, message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(long actual, long expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected);
			pass(actual, expected, null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(long actual, long expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected, message);
			pass(actual, expected, message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(Map<?, ?> actual, Map<?, ?> expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected);
			pass(actual, expected, null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(Map<?, ?> actual, Map<?, ?> expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected, message);
			pass(actual, expected, message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(Object[] actual, Object[] expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected);
			pass(actual,expected,null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(Object[] actual, Object[] expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected, message);
			pass(actual,expected,message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	public static void assertEquals(Short actual, Short expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected);
			pass(actual, expected, null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(Short actual, Short expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected, message);
			pass(actual, expected, message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(String actual, String expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected);
			pass(actual, expected, null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEquals(String actual, String expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEquals(actual, expected,message);
			pass(actual, expected, message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEqualsDeep(Map<?,?> actual, Map<?, ?> expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEqualsDeep(actual, expected);
			pass(actual, expected, null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEqualsDeep(Map<?,?> actual, Map<?, ?> expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEqualsDeep(actual, expected,message);
			pass(actual, expected, message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	
	public static void assertEqualsDeep(Set<?> actual, Set<?> expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEqualsDeep(actual, expected, message);
			pass(actual, expected, message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void assertEqualsNoOrder(Object[] actual, Object[] expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertEqualsNoOrder(actual, expected);
			pass(actual,expected,null);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	
	public static void assertEqualsNoOrder(Object[] actual, Object[] expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertEqualsNoOrder(actual, expected, message);
			pass(actual,expected,message);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertFalse(boolean condition) throws Exception
	{
		try
		{
			org.testng.Assert.assertFalse(condition);
			boolean expected=false;
			LogStatus.pass("Expected result: "+expected+" actual result: "+condition);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertFalse(boolean condition, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertFalse(condition);
			boolean expected=false;
			LogStatus.pass(message+": Expected result: "+expected+" actual result: "+condition);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertNotEquals(Object actual, Object expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertNotEquals(actual, actual);
			LogStatus.pass("Expected result: "+expected+"is not eqauals to actual result: "+actual);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertNotEquals(Object actual, Object expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertNotEquals(actual, actual,message);
			LogStatus.pass(message+" :Expected result: "+expected+"is not eqauals to actual result: "+actual);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertNotEquals(Map<?, ?> actual, Map<?, ?> expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertNotEquals(actual, expected);
			LogStatus.pass("Expected result: "+expected+"is not eqauals to actual result: "+actual);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertNotEquals(Map<?, ?> actual, Map<?, ?> expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertNotEquals(actual, expected,message);
			LogStatus.pass(message+" :Expected result: "+expected+"is not eqauals to actual result: "+actual);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	public static void 	assertNotEquals(Set actual, Set expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertNotEquals(actual, expected);
			LogStatus.pass("Expected result: "+expected+"is not eqauals to actual result: "+actual);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertNotEquals(Set actual, Set expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertNotEquals(actual, expected,message);
			LogStatus.pass(message+" :Expected result: "+expected+"is not eqauals to actual result: "+actual);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertNotEqualsDeep(Set actual, Set expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertNotEqualsDeep(actual, expected);
			LogStatus.pass("Expected result: "+expected+"is not eqauals to actual result: "+actual);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertNotEqualsDeep(Set actual, Set expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertNotEqualsDeep(actual, expected,message);
			LogStatus.pass(message+" :Expected result: "+expected+"is not eqauals to actual result: "+actual);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertNotEqualsDeep(Map<?, ?> actual, Map<?, ?> expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertNotEqualsDeep(actual, expected);
			LogStatus.pass("Expected result: "+expected+"is not eqauals to actual result: "+actual);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertNotEqualsDeep(Map<?, ?> actual, Map<?, ?> expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertNotEqualsDeep(actual, expected, message);
			LogStatus.pass(message+" :Expected result: "+expected+"is not eqauals to actual result: "+actual);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertNotEqualsDeep(Object[] actual, Object[] expected) throws Exception
	{
		try
		{
			if(Arrays.deepEquals(actual, expected))
				LogStatus.pass("Expected result: "+Arrays.toString(expected)+"is not eqauals to actual result: "+Arrays.toString(actual));
			else
				throw new AssertionError ("Expected result: "+Arrays.toString(expected)+"is not eqauals to actual result: "+Arrays.toString(actual));
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertNotEqualsDeep(Object[] actual, Object[] expected, String message) throws Exception
	{
		try
		{
			if(Arrays.deepEquals(actual, expected))
				LogStatus.pass(message+" :Expected result: "+Arrays.toString(expected)+"is not eqauals to actual result: "+Arrays.toString(actual));
			else
				throw new AssertionError (message+" :Expected result: "+Arrays.toString(expected)+"is not eqauals to actual result: "+Arrays.toString(actual));
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertNotNull(Object object) throws Exception
	{
		try
		{
			org.testng.Assert.assertNotNull(object);
			LogStatus.pass(object+" is not null");
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertNotNull(Object object, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertNotNull(object,message);
			LogStatus.pass(message+" : "+object+" is not null");
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	public static void 	assertNotSame(Object actual, Object expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertNotSame(actual, expected);;
			LogStatus.pass(actual+" is not same as "+expected);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertNotSame(Object actual, Object expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertNotSame(actual, expected,message);;
			LogStatus.pass(message+" : "+actual+" is not same as "+expected);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertNull(Object object) throws Exception
	{
		try
		{
			org.testng.Assert.assertNull(object);
			LogStatus.pass(object+" is null as expected");
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertNull(Object object, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertNull(object,message);
			LogStatus.pass(message+" : "+object+" is null as expected");
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertSame(Object actual, Object expected) throws Exception
	{
		try
		{
			org.testng.Assert.assertSame(actual, expected);;
			LogStatus.pass(actual+" is same as "+expected);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertSame(Object actual, Object expected, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertSame(actual, expected, message);
			LogStatus.pass(message+" : "+actual+" is same as "+expected);
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	public static void 	assertTrue(boolean condition) throws Exception
	{
		try
		{
			org.testng.Assert.assertTrue(condition);
			LogStatus.pass(condition +" is same as expected");
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	assertTrue(boolean condition, String message) throws Exception
	{
		try
		{
			org.testng.Assert.assertTrue(condition, message);
			LogStatus.pass(message+" : "+condition +" is same as expected");
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	fail() throws Exception
	{
		try
		{
			org.testng.Assert.fail();
			
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	public static void 	fail(String message) throws Exception
	{
		try
		{
			org.testng.Assert.fail(message);
			
		}
		catch(AssertionError e)
		{
			LogStatus.fail(e);
			e.printStackTrace();
		}
	}
	
	
	
	
}
