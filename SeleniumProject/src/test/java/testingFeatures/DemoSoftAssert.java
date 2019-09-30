package testingFeatures;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssert {
  @Test
  public void f() {
	  SoftAssert sa=new SoftAssert();
	  
	  System.out.println("Test1 - checking the 1st test");
	  sa.assertEquals(20, 12);
	  System.out.println("Test2 - checking the 2nd test");
	  sa.assertTrue("Selenium".contains("basic"), "Error msg");
	  
	  sa.assertAll();   //collects all error msg and display them
  }
}
