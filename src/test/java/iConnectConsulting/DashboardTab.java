/**
 * 
 */
package iConnectConsulting;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iConnectConsulting.pageobjects.CommonElements;
import com.iConnectConsulting.pageobjects.DashBoardPage_PO;
import com.iConnectConsulting.pageobjects.SignInPage_PO;

/**
 * @author dancalif
 *
 */
public class DashboardTab extends MainTest {
	
	

	@Test(enabled = true)
	public void dashboardTab() throws InterruptedException {
		//Login to the portal
		SignInPage_PO signInPage = PageFactory.initElements(driver, SignInPage_PO.class);
		signInPage.login(driver, user);
		CommonElements commonElements = PageFactory.initElements(driver, CommonElements.class);
		//Clicking Dashboard Tab
		commonElements.clickDashboardTab(driver);
		DashBoardPage_PO dashBoradPage = PageFactory.initElements(driver, DashBoardPage_PO.class);
		Thread.sleep(1000);
		//Assert if user is properly navigated
		Assert.assertTrue(dashBoradPage.ifdashBoardPageDisplayed(driver), "DashBoard Page Page is not shown up");

	}
}
