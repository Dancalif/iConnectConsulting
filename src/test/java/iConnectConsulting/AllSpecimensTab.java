/**
 * 
 */
package iConnectConsulting;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iConnectConsulting.pageobjects.AllSpecimensPage_PO;
import com.iConnectConsulting.pageobjects.CommonElements;
import com.iConnectConsulting.pageobjects.DashBoardPage_PO;
import com.iConnectConsulting.pageobjects.SignInPage_PO;

/**
 * @author dancalif
 *
 */
public class AllSpecimensTab extends MainTest {

	@Test(enabled = true)
	public void allSpecimensTab() throws InterruptedException {
		//Login to the portal
		SignInPage_PO signInPage = PageFactory.initElements(driver, SignInPage_PO.class);
		signInPage.login(driver, user);
		CommonElements commonElements = PageFactory.initElements(driver, CommonElements.class);
		//Clicking All Specimens Tab
		commonElements.clickAllSpecimensTab(driver);
		AllSpecimensPage_PO allSpecimensPage = PageFactory.initElements(driver, AllSpecimensPage_PO.class);;
		//Assert if user is navigated to the proper page
		Thread.sleep(2000);
		Assert.assertTrue(allSpecimensPage.ifAllSpecimensPageDisplayed(driver), "AllSpecimens Page is not shown up");
	}
}
