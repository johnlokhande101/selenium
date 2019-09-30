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

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CreateReport {
	ExtentHtmlReporter htmlreporter;
	ExtentReports extent;
	ExtentTest logger;
	

  
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
  }
  
	
  @Test
  public void passTest() {
	  
	  logger=extent.createTest("passTest");
	  Assert.assertTrue(true);
	  logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));  
  }
  
	
  @Test
  public void failTest() {	  
	  logger=extent.createTest("failTest");
	  Assert.assertTrue(false);
	  //logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));	  	  
  }
  
	
  @Test
  public void skipTest()
  {
  logger=extent.createTest("skipTest");
  throw new SkipException("Skipping - This is not ready for testing");
  // Assert.assertTrue(false);
  //logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
  }

  
  
  @AfterMethod
  public void getResult(ITestResult result)
  {
  if(result.getStatus()==ITestResult.FAILURE)
  {
  logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"- Test Case Failed",ExtentColor.RED));
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

