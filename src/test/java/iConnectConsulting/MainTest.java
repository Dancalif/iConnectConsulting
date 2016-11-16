package iConnectConsulting;

import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.iConnectConsulting.data.UserData;

import net.sf.cglib.core.Local;

public class MainTest {

	WebDriver driver;
	UserData user = new UserData("ptox", "ptox2013");
	private Local l;

	@BeforeMethod(alwaysRun = true)
	@org.testng.annotations.Parameters(value = { "conf", "environment" })
	public void setUp(String conf, String environment) throws Exception {

		JSONParser parser = new JSONParser();
		JSONObject config = (JSONObject) parser.parse(new FileReader(
				"/Users/dancalif/Dropbox/iConnect_workspace/iConnectConsulting/src/test/resources/" + conf));
		JSONObject envs = (JSONObject) config.get("environments");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
		Iterator it = envCapabilities.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
		}

		Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
		it = commonCapabilities.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (capabilities.getCapability(pair.getKey().toString()) == null) {
				capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
			}
		}

		String username = System.getenv("BROWSERSTACK_USERNAME");
		if (username == null) {
			username = (String) config.get("user");
		}

		String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
		if (accessKey == null) {
			accessKey = (String) config.get("key");
		}

		if (capabilities.getCapability("browserstack.local") != null
				&& capabilities.getCapability("browserstack.local") == "true") {
			// l = new Local();
			Map<String, String> options = new HashMap<String, String>();
			options.put("key", accessKey);
			// l.start(options);
		}

		driver = new RemoteWebDriver(
				new URL("http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"), capabilities);

		driver.get("https://www.labwebportal.com/Precision_v7_dev/#/login");

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		if (l != null)
			;
		// l.stop();
	}

	// if (browser.equalsIgnoreCase("chrome")) {
	// driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
	// DesiredCapabilities.chrome());
	// } else if (browser.equalsIgnoreCase("firefox")) {
	// driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
	// DesiredCapabilities.firefox());
	// }
	//
	// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	// driver.manage().window().maximize();
	// driver.get(url);
	// return;
}

// @AfterTest
// public void tearDown() {
// // Clean up environment
// driver.quit();
// }

// }
