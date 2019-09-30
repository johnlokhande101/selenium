package createworkbook;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class MercuryLoginExcel {
	
	public WebDriver driver;
	public WebDriverWait wait;
  @Test(dataProvider = "credentials")
  public void f(String username,String password) {
	  //driver.findElement(By.linkText("login")).click();
	  driver.findElement(By.name("userName")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.name("login")).click();
	  
	  WebElement signout=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SIGN-OFF")));
	  driver.findElement(By.linkText("SIGN-OFF")).click();
	  
	  //Assert.assertNotNull(signout);
  }

  @DataProvider (name="credentials")
  public Object[][] getData() throws IOException {
    return MyExcelReader.ReadData();
  }
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  wait=new WebDriverWait(driver,30);
	  driver.get("http://www.newtours.demoaut.com/");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
