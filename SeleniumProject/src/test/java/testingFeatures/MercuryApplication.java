package testingFeatures;

import org.testng.annotations.Test;

public class MercuryApplication {
	@Test(priority=1)
	public void openBrowser() {

		System.out.println("Open Browser");
	}

	@Test(priority=2)
	public void openURL() {

		System.out.println("Open URL");
	}

	@Test(priority=2)
	public void Login() {
		System.out.println("Login");
	}

	@Test(priority=4)
	public void searchFlight() {
		System.out.println("SearchFlight");
	}

	@Test(priority=5,enabled=false)
	public void bookFlight() {

		System.out.println("BookFlight");
	}

	@Test(priority=6)
	public void logout() {

		System.out.println("Logout");
	}

	@Test(priority=7)
	public void close() {
		System.out.println("Close");
	}
}
