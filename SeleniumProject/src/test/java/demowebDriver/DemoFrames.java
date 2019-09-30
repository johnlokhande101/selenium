package demowebDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class DemoFrames {
	WebDriver driver;
  @Test
  public void f() {
	  
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  WebElement about=driver.findElement(By.xpath("//span[contains(.,'AboutUs')]"));
	  
		 Actions act1=new Actions(driver);
		 act1.moveToElement(about).click().build().perform();
		 act1.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Our\n" + 
		 		"												Offices')]"))).click().build().perform();
		 act1.moveToElement(driver.findElement(By.xpath("//span[contains(.,'Bangalore')]"))).click().build().perform();
		
		 Set<String> set=driver.getWindowHandles();
		 for ( String str: set)
		 {
			 driver.switchTo().window(str);
			 
		 }
		 
		 driver.switchTo().frame(driver.findElement(By.name("main_page")));
		 String addr=driver.findElement(By.tagName("address")).getText();
		 System.out.println(addr);
  }
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
