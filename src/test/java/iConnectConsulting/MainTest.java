package iConnectConsulting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.iConnectConsulting.data.UserData;
import com.iConnectConsulting.pageobjects.CommonElements;
import com.iConnectConsulting.pageobjects.SignInPage_PO;

public class MainTest {

	WebDriver driver;
	UserData user = new UserData("yourUsername", "yourPassword");

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "url" })
	public WebDriver setUp(String browser, String url) throws Exception {
		// Launch the FireFox browser
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/dan/Dropbox/Portfolio_workspace/iconnectconsulting_dev/webDrivers/chromedriver");
			driver = new ChromeDriver();
		}
		// Navigate to AUT, managing the browser window
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		CommonElements commonElements = PageFactory.initElements(driver, CommonElements.class);
		commonElements.clickSignOut(driver);
		Thread.sleep(1000);
		SignInPage_PO signInPage = PageFactory.initElements(driver, SignInPage_PO.class);
		// Verify if user is signed out
		Assert.assertTrue(signInPage.doesUsernameExist(driver), "User is not signed out");
		Thread.sleep(1000);
		// Clean up environment
		driver.quit();
	}
}