package iConnectConsulting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.iConnectConsulting.data.UserData;

public class MainTest {

	public static WebDriver driver;
	public UserData user = new UserData("ptox", "ptox2013");

	@BeforeTest
	public WebDriver getWebDriver() {
		 if (driver == null) {
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.get("https://www.labwebportal.com/Precision_v7_dev/#/login");
		driver.manage().window().maximize();
		 }
		return driver;
	}

	@AfterTest
	public void tearDown() {
		// Clean up environment
		driver.quit();
	}

}
