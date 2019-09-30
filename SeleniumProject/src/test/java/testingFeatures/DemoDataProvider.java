package testingFeatures;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DemoDataProvider {
  @Test(dataProvider = "credentials")
  public void f(String username, String password) {
	  System.out.println("Username is "+username);
	  System.out.println("Password is "+password);
  }

  @DataProvider(name="credentials")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "abc", "123" },
      new Object[] {"xyz" , "789" },
      new Object[] {"pqr" , "345" },
    };
  }
}
