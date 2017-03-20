/**
 * 
 */
package iConnectConsulting;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iConnectConsulting.pageobjects.AllSpecimensPage_PO;
import com.iConnectConsulting.pageobjects.DashBoardPage_PO;
import com.iConnectConsulting.pageobjects.SignInPage_PO;

/**
 * @author dancalif
 *
 */
public class AllSpecimensTab extends MainTest {

	@Test(enabled = true)
	public void allSpecimensTab() throws InterruptedException {

		SignInPage_PO signInPage = PageFactory.initElements(driver, SignInPage_PO.class);
		Thread.sleep(3000);
		DashBoardPage_PO dashBoardPage = signInPage.login(driver, user);
		Thread.sleep(3000);
		signInPage.clickSignInButton(driver);
		AllSpecimensPage_PO allSpecimensPage = dashBoardPage.clickAllSpecimensButton(driver);
		// Verify if user successfully signed in
		Thread.sleep(2000);
		Assert.assertTrue(allSpecimensPage.ifAllSpecimensPageDisplayed(driver), "AllSpecimens Page is not shown up");
		// Sign out
		signInPage = dashBoardPage.clickSignOut(driver);
	}
}
