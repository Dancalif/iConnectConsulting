/**
 * 
 */
package iConnectConsulting;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iConnectConsulting.pageobjects.DashBoardPage;
import com.iConnectConsulting.pageobjects.PublishedReportsPage;
import com.iConnectConsulting.pageobjects.SignInPage;

/**
 * @author dancalif
 *
 */
public class PublishedReportsTab extends MainTest {

	@Test(enabled = true)
	public void dashboardTab() throws InterruptedException, MalformedURLException {

		Random rand = new Random();

		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
		Thread.sleep(3000);
		DashBoardPage dashBoardPage = signInPage.login(driver, user);
		Thread.sleep(3000);
		signInPage.clickSignInButton(driver);
		DashBoardPage dashBoradPage = dashBoardPage.clickDashboardTab(driver);
		Thread.sleep(1000);
		PublishedReportsTab publishedReportsTab = PublishedReportsPage.clickPublishedReportsTab(driver);

		List<WebElement> specimenIDsList = driver.findElements(By.cssSelector("table > tbody > tr > td:nth-child(3)"));
		int specimenIDsNum = specimenIDsList.size();
		int randomNum = rand.nextInt(specimenIDsNum);
		String specimenIDName = specimenIDsList.get(randomNum).getText();
		specimenIDsList.get(randomNum).click();
		Thread.sleep(2000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		WebElement reportSpecomenIDName = driver.findElement(By.cssSelector("textLayer>div:nth-child(68)"));
		String reportSpecomenIDNameText = reportSpecomenIDName.getText();
		Assert.assertEquals(specimenIDName, reportSpecomenIDNameText);
		Thread.sleep(2000);
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(2000);
	}

}
