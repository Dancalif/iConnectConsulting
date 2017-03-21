/**
 * 
 */
package iConnectConsulting;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iConnectConsulting.pageobjects.CommonElements;
import com.iConnectConsulting.pageobjects.DashBoardPage_PO;
import com.iConnectConsulting.pageobjects.PhysicianQueuePage_PO;
import com.iConnectConsulting.pageobjects.SignInPage_PO;

/**
 * @author dancalif
 *
 */
public class PhysicianQueueTab extends MainTest {

	@Test(enabled = true)
	public void allSpecimensTab() throws InterruptedException {
		//Login to the portal
		SignInPage_PO signInPage = PageFactory.initElements(driver, SignInPage_PO.class);
		signInPage.login(driver, user);
		CommonElements commonElements = PageFactory.initElements(driver, CommonElements.class);
		//Clicking Physician Queue Tab
		commonElements.clickPhysicianQueueTab(driver);
		PhysicianQueuePage_PO physicianQueuePage = PageFactory.initElements(driver, PhysicianQueuePage_PO.class);
		// Verify if user successfully signed in
		Thread.sleep(2000);
		//Assert if user is properly navigated
		Assert.assertTrue(physicianQueuePage.ifPhysicianQueuePageDisplayed(driver),
				"PhysicianQueue Page is not shown up");
	}
}
