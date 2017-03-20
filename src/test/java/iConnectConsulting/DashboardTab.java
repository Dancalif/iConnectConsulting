/**
 * 
 */
package iConnectConsulting;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iConnectConsulting.pageobjects.DashBoardPage_PO;
import com.iConnectConsulting.pageobjects.SignInPage_PO;

/**
 * @author dancalif
 *
 */
public class DashboardTab extends MainTest {

	@Test(enabled = true)
	public void dashboardTab() throws InterruptedException {

		SignInPage_PO signInPage = PageFactory.initElements(driver, SignInPage_PO.class);
		Thread.sleep(3000);
		DashBoardPage_PO dashBoardPage = signInPage.login(driver, user);
		Thread.sleep(3000);
		signInPage.clickSignInButton(driver);
		DashBoardPage_PO dashBoradPage = dashBoardPage.clickDashboardTab(driver);
		Thread.sleep(1000);
		Assert.assertTrue(dashBoardPage.ifdashBoardPageDisplayed(driver), "DashBoard Page Page is not shown up");
		// Sign out
		signInPage = dashBoardPage.clickSignOut(driver);
		Thread.sleep(1000);

	}
}
