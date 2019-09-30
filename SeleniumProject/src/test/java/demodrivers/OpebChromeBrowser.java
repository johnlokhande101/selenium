package demodrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpebChromeBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver=new ChromeDriver();   //opens chrome browser
		driver.get("https://www.seleniumhq.org/"); //get method to open website
		
		driver.manage().window().maximize();  //to maximize the window
		Thread.sleep(3000);    //to addd wait time
		driver.close();  //to close the window
	}

}
