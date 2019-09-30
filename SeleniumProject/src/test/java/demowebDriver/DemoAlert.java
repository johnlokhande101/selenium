package demowebDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class DemoAlert {
	WebDriver driver;
	
	
  @Test
  public void f() {
	  
	  driver.get("http://demo.automationtesting.in/Alerts.html");
	  driver.findElement(By.xpath("//a[contains(.,'Alert with Textbox')]")).click();
	  WebDriverWait wait=new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.presenceOfElementLocated(
			  By.xpath("//button[@onclick='promptbox()']")));
	  driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
	  
	  Alert alertBX=driver.switchTo().alert();
	  String msg=alertBX.getText();
	  System.out.println("Alert msg is :"+msg);
	  alertBX.sendKeys("Akash");
	  alertBX.accept();
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","resources\\chromedriver.exe");
	  driver=new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
  }

}
