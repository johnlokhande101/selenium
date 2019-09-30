package demowebDriver;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginMercury {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  driver.get("http://www.newtours.demoaut.com/");
	  
	  // gets the title and verifies it with expected result
	  
	  String pageTitle=driver.getTitle();
	  Assert.assertEquals(pageTitle, "Welcome: Mercury Tours");
	  
	  
	  driver.findElement(By.name("userName")).sendKeys("mercury");
	  driver.findElement(By.name("password")).sendKeys("mercury");
	  driver.findElement(By.name("login")).click();
	  
	  Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
	  
	  Thread.sleep(3000);
	  
	  driver.findElement(By.linkText("SIGN-OFF")).click();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
