/**
 * 
 */
package iConnectConsulting;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author dancalif
 *
 */
public class LabwebportalLoginTest {
	WebDriver driver = new FirefoxDriver();

	// @Test
	// public void labwebportalLoginPass() {
	// // 1. Got to www.labwebportal.com
	// driver.get("https://www.labwebportal.com/Precision_v7_dev/#/login");
	// // 2. Fill in username
	// WebElement usernameTextField = driver.findElement(By.id("username"));
	// usernameTextField.clear();
	// usernameTextField.sendKeys("ptox");
	// // 3. Fill in password
	// WebElement passwordTextField = driver.findElement(By.name("password"));
	// passwordTextField.clear();
	// passwordTextField.sendKeys("ptox2013");
	// // 4. Click Sing in button
	// WebElement signInButton =
	// driver.findElement(By.xpath("//*[@type='submit']"));
	// signInButton.click();
	// // 5. Verify if user successfully signed in
	// WebDriverWait wait = new WebDriverWait(driver, 30);
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#/dashboard']")));
	// Assert.assertTrue("Dashboard exists",
	// driver.findElement(By.cssSelector("a[href='#/dashboard']")).isDisplayed());
	// WebElement profileButton = driver.findElement(By.xpath("//*[@class = 'fa
	// fa-caret-down']"));
	// profileButton.click();
	// WebElement signoutButton = driver.findElement(By.linkText("Logout"));
	// signoutButton.click();
	// // 6. Verify if user is signed out
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).isDisplayed();
	// Assert.assertTrue("User is not signed out",
	// driver.findElement(By.id("username")).isDisplayed());
	// }

	@Test
	public void testOrderSubmit() {
		// 1. Got to www.labwebportal.com
		driver.get("https://www.labwebportal.com/Precision_v7_dev/#/login");
		// 2. Fill in username
		WebElement usernameTextField = driver.findElement(By.id("username"));
		usernameTextField.clear();
		usernameTextField.sendKeys("ptox");
		// 3. Fill in password
		WebElement passwordTextField = driver.findElement(By.name("password"));
		passwordTextField.clear();
		passwordTextField.sendKeys("ptox2013");
		// 4. Click Sing in button
		WebElement signInButton = driver.findElement(By.xpath("//*[@type='submit']"));
		signInButton.click();
		// 5. Verify if user successfully signed in
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#/dashboard']")));
		Assert.assertTrue("Dashboard exists",
				driver.findElement(By.cssSelector("a[href='#/dashboard']")).isDisplayed());
		// 6. Click Test Order button on the navigation panel
		WebElement testOrder = driver.findElement(By.cssSelector("a[href='#/test-order']"));
		testOrder.click();
		// 7. Fill in Specimen Id textfield
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("input[class^='form-control'][type$='text'][data-role$='maskedtextbox']")));
		WebElement specimenID = driver
				.findElement(By.cssSelector("input[class^='form-control'][type$='text'][data-role$='maskedtextbox']"));
		specimenID.clear();
		specimenID.sendKeys("dan12346");
		// 8. Click Physician Name textfield
		// 9. Select any physician
		// 10. Click Apply selected button
		// 11. Click Last Name box
		// 12. Select any existing patient
		// Click Apply selected button
		// Select Uninsured radiobutton under Billing Method
		// Enter 304 under DIAGNOSIS CODES
		// Select any diagnos from dropdown menue
		// Click Urine radiobutton under SPECIMEN TYPE
		// Click RECORD POC RESULTS to expand the options
		// Select several checkboxes under RECORD POC RESULTS
		// Click Perform Custom Profile under SELECT YOUR TESTING OPTION
		// Check several checkboxes under PATIENT'S PRESCRIBED MEDICATIONS
		// Enter initials into the Collector's initials textfield
		// Click Submit button
		// Click Agree on the desclaimer
		// Verify if Order placed module is displayed
	}

	// @After
	// public void tearDown() {
	// // Clean up enviroment
	// driver.quit();
	// }
}
