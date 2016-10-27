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
public class SignIn extends MainTest {
	@Test(enabled = true)
	public void labwebportalLoginPass() throws InterruptedException {
		System.out.print("Hello!!! Hello!!!");
		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
		DashBoardPage dashBoardPage = signInPage.login(driver, user);
		signInPage.clickSignInButton(driver);
		// Verify if user successfully signed in
		Thread.sleep(2000);
		Assert.assertTrue(dashBoardPage.doesDashboardExist(driver), "Dashboard is not shown up");
		// Sign out
		signInPage = dashBoardPage.signOut(driver);
		// Verify if user is signed out
		Assert.assertTrue(signInPage.doesUsernameExist(driver), "User is not signed out");
	}
}
