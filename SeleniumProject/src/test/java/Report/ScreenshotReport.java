package Report;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.FileUtil;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
//import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ScreenshotReport {
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;

  
  @BeforeTest
  public void startReport() {
	  
	  htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir") +"/extent-reports/"
			  +new SimpleDateFormat("hh-mm-ss-ms-dd-MM-yyyy").format(new Date(0))+".html");
	  
	  extent =new ExtentReports();
	  extent.attachReporter(htmlreporter);
	  extent.setSystemInfo("Host Name", "GFT Nexgen testing Stream");
	  extent.setSystemInfo("Envirnment", "Automation testing - Selenium");
	  extent.setSystemInfo("User Name", "Akash ");
	  
	  
	  htmlreporter.config().setDocumentTitle("Title of the Report comes here");
	  htmlreporter.config().setReportName("Name og the report appears here");
	  htmlreporter.config().setTheme(Theme.STANDARD);	  
	  
	  
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
	  driver= new ChromeDriver();
	  
  }
  
  
  @Test
  public void failTestDemoWebShop() 
  {
  logger= extent.createTest("failTest");
  driver.manage().window().maximize();
  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
  driver.findElement(By.id("userName")).sendKeys("Lalitha");
  driver.findElement(By.id("pass")).sendKeys("Password123");
  driver.findElement(By.name("Login")).click();
  
  Assert.assertTrue(driver.findElement(By.linkText("SignOut")).isDisplayed());
  driver.findElement(By.linkText("SignOut")).click();
  
  }
  
   @AfterMethod
  public void getResult(ITestResult result) throws IOException
  {
  if(result.getStatus()==ITestResult.FAILURE)
  {
  logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"- Test Case Failed",ExtentColor.RED));
  //logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable()+"- Test Case Failed",ExtentColor.RED));
  TakesScreenshot snapshot=(TakesScreenshot)driver;
  File src=snapshot.getScreenshotAs(OutputType.FILE);
  String path=System.getProperty("user.dir") +"/extent-reports/snapshots/"+result.getName()+".png";
  FileUtils.copyFile(src,new File(path));
 //FileHandler.copy(src,new File(path));
  
  logger.addScreenCaptureFromPath(path,result.getName());
  
  logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable()+"- Test Case Failed",ExtentColor.RED));
  }

  else if(result.getStatus()==ITestResult.SKIP) {

  logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"- Test Case Skipped",ExtentColor.ORANGE));
  }
  }

  
@AfterTest
public void endReport() {
extent.flush();
} 
  
}

