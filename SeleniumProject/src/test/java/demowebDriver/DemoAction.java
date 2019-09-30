package demowebDriver;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class DemoAction {
   WebDriver driver;
  @Test
  public void f() {
	  
	  driver.get("http://10.232.237.143:443/TestMeApp/");
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  WebElement search=driver.findElement(By.id("myInput"));
	  Actions act1=new Actions(driver);
	  act1.keyDown(search,Keys.SHIFT).perform();
	  act1.sendKeys("b").pause(3000).sendKeys("a").pause(3000).sendKeys("g").perform();
	  act1.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Hand bag')]"))).click().perform();
	  
	  
	  driver.findElement(By.cssSelector("input[value='FIND DETAILS']")).click();
	  
	  
	  String text=driver.findElement(By.xpath("//h4[contains(text(),'Hand bag')]")).getText();
	  Assert.assertTrue(text.contains("Hand bag"));
	  
	  
	 // /html/body/div[1]/form/input
	  
	  ///html/body/div[1]/form/input
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","resources\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
