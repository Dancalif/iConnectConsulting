/**
 * 
 */
package iConnectConsulting;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iConnectConsulting.pageobjects.DashBoardPage;
import com.iConnectConsulting.pageobjects.SignInPage;

/**
 * @author dancalif
 *
 */
public class DashboardTab extends MainTest {

	@Test(enabled = true)
	public void dashboardTab() throws InterruptedException {

		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
		Thread.sleep(3000);
		DashBoardPage dashBoardPage = signInPage.login(driver, user);
		Thread.sleep(3000);
		signInPage.clickSignInButton(driver);
		Assert.assertTrue(dashBoardPage.ifdashBoardPageDisplayed(driver), "DashBoard Page Page is not shown up");
		// Sign out
		signInPage = dashBoardPage.signOut(driver);

	}
}
