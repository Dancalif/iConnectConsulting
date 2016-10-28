/**
 * 
 */
package iConnectConsulting;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iConnectConsulting.pageobjects.AllSpecimensPage;
import com.iConnectConsulting.pageobjects.DashBoardPage;
import com.iConnectConsulting.pageobjects.SignInPage;

/**
 * @author dancalif
 *
 */
public class AllSpecimensTab extends MainTest {

	@Test(enabled = true)
	public void allSpecimensTab() throws InterruptedException {

		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
		Thread.sleep(3000);
		DashBoardPage dashBoardPage = signInPage.login(driver, user);
		Thread.sleep(3000);
		signInPage.clickSignInButton(driver);
		AllSpecimensPage allSpecimensPage = dashBoardPage.clickAllSpecimensButton(driver);
		// Verify if user successfully signed in
		Thread.sleep(2000);
		Assert.assertTrue(allSpecimensPage.ifAllSpecimensPageDisplayed(driver), "AllSpecimens Page is not shown up");
		// Sign out
		signInPage = dashBoardPage.signOut(driver);
	}
}
