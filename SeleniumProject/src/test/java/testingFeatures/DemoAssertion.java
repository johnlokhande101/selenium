package testingFeatures;

import org.testng.Assert;
//import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class DemoAssertion {
  @Test
  public void test1() {
	  System.out.println("test1 started");
	  Assert.assertEquals("Akash", "John");
	  System.out.println("test1 completed");
  }
  
  @Test
  public void test2() {
	  System.out.println("test2 started");
	  Assert.assertNotEquals("Hello","Hi");
	  System.out.println("test2 completed");
  }
  
  @Test
  public void test3() {
	  System.out.println("test3 started");
	  Assert.assertTrue("selenium".contains("len"), "Does not contain");
	  System.out.println("test3 completed");
  }
  
  @Test
  public void test4() {
	  System.out.println("test4 started");
	  Assert.assertFalse(20<18, "18 less than 20");
	  System.out.println("test4 completed");
  }
  
  @Test
  public void test5() {
	  Object test=null;
	  Assert.assertNull(test, "Its not null");
  }
  
  @Test
  public void test6() {
	  Assert.fail("Intentionally fail");
	  

  }
  @Test
  public void test7() {
	  
	  Object test1="abc";
	  Object test2="abc";
	  Assert.assertSame(test1, test2);
	  
  }
}
