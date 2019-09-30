package demowebDriver;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class DemoMouseAction {
	WebDriver driver;
  @Test
  public void f() {
	  
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 Actions actions=new Actions(driver);
	// actions.moveToElement(By.xpath(""))
	 
	 
	 actions.moveToElement(driver.findElement(By.xpath("//a[contains(.,'AboutUs')]"))).click().pause(300)
	 .moveToElement(driver.findElement(By.xpath("//span[contains(.,'Our\n" + 
	 		"												Offices')]"))).click().pause(300)
	 .moveToElement(driver.findElement(By.xpath("//span[contains(.,'Chennai')]"))).click().build().perform();
	 //Assert.assertTrue(driver.getCurrentUrl().contains("chn"));
	 //Assert.assertEquals(driver.getTitle(),"Contact Us");
  }
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver","resources\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
	  //driver.close();
  }

}
