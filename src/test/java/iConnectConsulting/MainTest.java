package iConnectConsulting;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.iConnectConsulting.data.UserData;
import com.iConnectConsulting.pageobjects.DashBoardPage_PO;
import com.iConnectConsulting.pageobjects.SignInPage_PO;

import net.sf.cglib.core.Local;

public class MainTest {

	WebDriver driver;
	UserData user = new UserData("ptox", "ptox2013");
	private Local l;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser", "url" })
	public WebDriver setUp(String browser, String url) throws Exception {
			// Launch the FireFox browser
			if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"/Users/dan/Dropbox/iConnectConsulting_workspace/iconnectconsulting_dev/webDrivers/chromedriver");
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
		SignInPage_PO signInPage = PageFactory.initElements(driver, SignInPage_PO.class);
		signInPage = DashBoardPage_PO.signOut(driver);
		// Verify if user is signed out
		Assert.assertTrue(signInPage.doesUsernameExist(driver), "User is not signed out");
		// Clean up environment
		driver.quit();
	}
}