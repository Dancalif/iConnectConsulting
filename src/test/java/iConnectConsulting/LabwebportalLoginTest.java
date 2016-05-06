/**
 * 
 */
package iConnectConsulting;

import java.util.List;
import java.util.Random;

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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input")));
		WebElement specimenID = driver.findElement(By.cssSelector("input"));
		specimenID.clear();
		specimenID.sendKeys("dan12346");
		// 8. Click Physician Name textfield
		WebElement physicianName = driver.findElement(By.cssSelector("i[class='fa fa-ellipsis-h']"));
		physicianName.click();
		// 9. Select any physician
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("k-grid-content")));
		WebElement physicianNameTable = driver.findElement(By.className("k-grid-content"));
		List<WebElement> rowsPhysicianName = physicianNameTable.findElements(By.tagName("tr"));
		Random rand = new Random();
		int randomNumber = rand.nextInt(rowsPhysicianName.size());
		for (int i = 0; i < rowsPhysicianName.size(); i++) {
			if (i == randomNumber) {
				rowsPhysicianName.get(i).click();
				break;
			}
		}
		// 10. Click Apply selected button
		WebElement applySelectedButtonPhysicians = driver
				.findElement(By.xpath("//button[@class='btn btn-primary btn-form-md']"));
		applySelectedButtonPhysicians.click();
		// 11. Click Last Name box
		WebElement lastNameTextField = driver
				.findElement(By.cssSelector("input[class='item-focusable order-field-input empty']"));
		lastNameTextField.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("button[class='btn btn-default btn-form-md pull-left ng-scope']")));
		// 12. Click Add New button
		WebElement addNewButton = driver
				.findElement(By.cssSelector("button[class='btn btn-default btn-form-md pull-left ng-scope']"));
		addNewButton.click();
		// Fill out Last name text field

		WebElement addLastName = driver.findElement(By.xpath("(//input[@type='text'])[42]"));
		addLastName.sendKeys("Hello");
		WebElement addFirstName = driver.findElement(By.xpath("(//input[@type='text'])[43]"));
		addFirstName.sendKeys("Hello");
		WebElement addDateOfBirth = driver.findElement(By.cssSelector(
				"input[class='form-control item-focusable order-field-input ng-pristine ng-untouched ng-valid empty k-input']"));
		addDateOfBirth.sendKeys("12/21/1978");
		List<WebElement> maleFemaleRadioButton = driver
				.findElements(By.cssSelector("fa-radio[class='ng-scope ng-isolate-scope']"));
		maleFemaleRadioButton.get(1).click();

		WebElement submitButton = driver.findElement(By.cssSelector("button[class='btn btn-primary btn-form-md']"));
		submitButton.click();

		// Fill out First name text field
		// Fill out Date of Birth
		// Select Gender radio button
		// Click Submit button
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

		// // Select any existing patient
		// WebElement patientsNameTable =
		// driver.findElement(By.className("k-grid-content"));
		// List<WebElement> rowsPatientsName =
		// patientsNameTable.findElements(By.tagName("tr"));
		// randomNumber = rand.nextInt(rowsPatientsName.size());
		// for (int i = 0; i < rowsPatientsName.size(); i++) {
		// if (i == randomNumber) {
		// rowsPatientsName.get(i).click();
		// break;
		// }
		// }
		// // Click Apply selected button
		// WebElement applySelectedButtonPatinets = driver
		// .findElement(By.xpath("//button[@class='btn btn-primary
		// btn-form-md']"));
		// applySelectedButtonPatinets.click();

	}

	// @After
	// public void tearDown() {
	// // Clean up enviroment
	// driver.quit();
	// }
}
