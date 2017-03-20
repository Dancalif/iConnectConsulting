/**
 * 
 */
package iConnectConsulting;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iConnectConsulting.pageobjects.DashBoardPage_PO;
import com.iConnectConsulting.pageobjects.SignInPage_PO;
import com.iConnectConsulting.util.WebUtil;

/**
 * @author dancalif
 *
 */
public class SignIn extends MainTest {
	@Test(enabled = true)
	public void labwebportalLoginPass() throws InterruptedException {
		SignInPage_PO signInPage = PageFactory.initElements(driver, SignInPage_PO.class);
		// DashBoardPage dashBoardPage = signInPage.login(driver, user);
		// signInPage.clickSignInButton(driver);
		// Verify if user successfully signed in
		WebUtil.waitForElementVisible(driver, By.cssSelector("a[href='#/dashboard']"));
		Assert.assertTrue(DashBoardPage_PO.doesDashboardExist(driver), "Dashboard is not shown up");
		// Sign out
		signInPage = DashBoardPage_PO.clickSignOut(driver);
		// Verify if user is signed out
		Assert.assertTrue(signInPage.doesUsernameExist(driver), "User is not signed out");
	}
}
