/**
 * 
 */
package iConnectConsulting;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iConnectConsulting.pageobjects.PublishedReportsPage;
import com.iConnectConsulting.util.WebUtil;

/**
 * @author dancalif
 *
 */
public class PublishedReportsTab extends MainTest {

	@Test(enabled = true)
	public void dashboardTab() throws InterruptedException, MalformedURLException {

		Random rand = new Random();
		WebUtil.waitForElementVisible(driver, By.cssSelector("a[href='#/reports-all']"));

		PublishedReportsTab publishedReportsTab = PublishedReportsPage.clickPublishedReportsTab(driver);

		List<WebElement> specimenIDsList = driver.findElements(By.cssSelector("table > tbody > tr > td:nth-child(3)"));
		int specimenIDsNum = specimenIDsList.size();
		int randomNum = rand.nextInt(specimenIDsNum);
		String specimenIDName = specimenIDsList.get(randomNum).getText();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", specimenIDsList.get(randomNum));

		Thread.sleep(2000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		List<WebElement> reportSpecomenIDNames = driver.findElements(By.cssSelector("div[class='textLayer'] > div"));

		for (WebElement nextItem : reportSpecomenIDNames) {
			if (nextItem.getText().contains(specimenIDName)) {
				Assert.assertEquals(specimenIDName, nextItem.getText());
				Thread.sleep(1000);
				break;
			} else {
			}
		}
	}
}
