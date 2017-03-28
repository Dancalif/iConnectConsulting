/**
 * 
 */
package iConnectConsulting;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iConnectConsulting.pageobjects.CommonElements;
import com.iConnectConsulting.pageobjects.PublishedReportsPage_PO;
import com.iConnectConsulting.pageobjects.SignInPage_PO;

/**
 * @author dancalif
 *
 */
public class PublishedReportsTab extends MainTest {

	@Test(enabled = true)
	public void dashboardTab() throws InterruptedException, MalformedURLException {
		// Login to the portal
		SignInPage_PO signInPage = PageFactory.initElements(driver, SignInPage_PO.class);
		signInPage.login(driver, user);
		CommonElements commonElements = PageFactory.initElements(driver, CommonElements.class);
		// Clicking Published Reports Tab
		commonElements.clickPublishedReportsTab(driver);
		PublishedReportsPage_PO publishedReportsPage = PageFactory.initElements(driver, PublishedReportsPage_PO.class);
		// Assert if user is navigated to th proper page
		Assert.assertTrue(publishedReportsPage.ifPublishedReportsPageDisplayed(driver),
				"Published Reports Page is not shown up");
		// Assert if Specimen ID is displayed on the report
		publishedReportsPage.verifySpecimenIDonTheReport(driver);
	}
}
