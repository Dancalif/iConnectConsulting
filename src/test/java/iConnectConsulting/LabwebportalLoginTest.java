/**
 * 
 */
package iConnectConsulting;

import org.junit.After;
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

	@Test
	public void labwebportalLoginPass() {
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
		WebElement profileButton = driver.findElement(By.xpath("//*[@class = 'fa fa-caret-down']"));
		profileButton.click();
		WebElement signoutButton = driver.findElement(By.linkText("Logout"));
		signoutButton.click();
		// Verify if user is signed out
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).isDisplayed();
		Assert.assertTrue("User is not signed out", driver.findElement(By.id("username")).isDisplayed());
	}

	@After
	public void tearDown() {
		// Clean up enviroment
		driver.quit();
	}

}
