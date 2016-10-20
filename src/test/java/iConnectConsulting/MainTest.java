package iConnectConsulting;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.iConnectConsulting.data.UserData;

public class MainTest {

	WebDriver driver;
	UserData user = new UserData("ptox", "ptox2013");

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void getWebDriver(String browser, String url) throws Exception {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
		}

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		return;
	}

	@AfterTest
	public void tearDown() {
		// Clean up environment
		driver.quit();
	}

}
