/**
 * 
 */
package iConnectConsulting;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author dancalif
 *
 */
public class Test {

	// @Test(enabled = true)
	public static void main(String[] args) throws InterruptedException {

		Random rand = new Random();
		//
		// // Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		//
		driver.get("https://www.labwebportal.com/Precision_v7_dev/#/login");
		// WebElement inputUsername = driver.findElement(By.id("username"));
		// inputUsername.sendKeys("ptox");
		// WebElement inputPassworde = driver.findElement(By.name("password"));
		// inputUsername.sendKeys("ptox2013");
		//
		// WebUtil.click(driver, By.cssSelector("a[href='#/reports-all']"));
		//
		// List<WebElement> specimenIDsList =
		// driver.findElements(By.cssSelector("table > tbody > tr >
		// td:nth-child(3)"));
		// int specimenIDsNum = specimenIDsList.size();
		// int randomNum = rand.nextInt(specimenIDsNum);
		// String specimenIDName = specimenIDsList.get(randomNum).getText();
		// specimenIDsList.get(randomNum).click();
		// Thread.sleep(2000);
		// ArrayList<String> tabs2 = new
		// ArrayList<String>(driver.getWindowHandles());
		// driver.switchTo().window(tabs2.get(1));
		// WebElement reportSpecomenIDName =
		// driver.findElement(By.cssSelector("textLayer>div:nth-child(68)"));
		// String reportSpecomenIDNameText = reportSpecomenIDName.getText();
		// Assert.assertEquals(specimenIDName, reportSpecomenIDNameText);
		// Thread.sleep(2000);
		// driver.switchTo().window(tabs2.get(0));
		// Thread.sleep(2000);
	}

}
