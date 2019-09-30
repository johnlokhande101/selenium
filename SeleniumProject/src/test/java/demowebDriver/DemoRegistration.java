package demowebDriver;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DemoRegistration {
	
	WebDriver driver;
  @Test
  public void f() {
	  
	  driver.get("http://newtours.demoaut.com/");
	  
	  Assert.assertEquals(driver.getTitle(),"Welcome: Mercury Tours");
	  
	  driver.findElement(By.linkText("REGISTER")).click();
	  Assert.assertEquals(driver.getTitle(), "Register: Mercury Tours");
	  
	  driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Akash");
	  driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("abc");
	  driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("78954");
	  
	  
	 driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("abc@gmail.com");
	 
	 driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("kasarwadi");
	 
	 driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Pune");
	 
	 driver.findElement(By.xpath("//input[@name='state']")).sendKeys("maharashtra");
	 driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("411034");
	 
	 //To select value from combobox
	 Select country=new Select(driver.findElement(By.name("country")));
	 //country.selectByIndex(4);
	 
	 //country.selectByValue("8");
	 country.selectByVisibleText("INDIA");
	 
	 
	 
	 
	 driver.findElement(By.xpath("//input[@name='email']")).sendKeys("xyz");
	 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("xyz");
	 driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("xyz");
	 
	 driver.findElement(By.xpath("//input[@name='register']")).submit();

  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	 
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(6000);
	  driver.close();
  }

}
