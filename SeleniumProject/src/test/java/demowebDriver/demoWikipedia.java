package demowebDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class demoWikipedia {
	WebDriver driver;
  @Test
  public void f() {
	  
	  driver.get("https://www.wikipedia.org/wiki/Main_Page");
	  
	  driver.findElement(By.linkText("History")).click();
	  
	  String url=driver.getCurrentUrl();      //to get current url
	  System.out.println("Current url is "+url);
	  
	 // String str=driver.getPageSource();
	 // System.out.println(str);
	  System.out.println(driver.getPageSource());   //to print HTML code
  }
  

  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver","resources\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
