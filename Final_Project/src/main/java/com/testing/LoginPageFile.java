package com.testing;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageFile extends LocatorsFile implements LoginDataFile {

	public WebDriver driver;

	public void openBrowser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mansi\\eclipse-workspace\\Final_Project\\Project_Data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); // Delete cookies
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/");

		Thread.sleep(1000);
		PageFactory.initElements(driver, this);

	}

	public void closeBrowser() {
		driver.close();
	}

	/* TC_Login_001 --> Email/Phone TextBox is displayed or not */
	
	public void emailDisplayed() {
		
		if (emailTextbox.isDisplayed())
			System.out.println("TC_Login_001 - Email/Phone TextBox is displayed successfully");
		else
			System.out.println("TC_Login_001 - Email/Phone TextBox is not displayed");
	}

	/* TC_Login_002 --> Next Button is displayed or not */
	
	public void nextDisplayed() {
		
		if (nextButton.isDisplayed())
			System.out.println("TC_Login_002 - Next button is displayed successfully");
		else
			System.out.println("TC_Login_002 - Next button is not displayed");
	}

	
	/* TC_Login_003 -->logging into the Application without providing any credentials
	 * TC_Login_004 to TC_Login_007 -->Invalid credentials (Invalid email address) */

	public void invalidEmail() throws InterruptedException {
		Xls_Reader data = new Xls_Reader("D:\\Selenium Java class\\final_Project_Doc\\userData.xlsx");
		String sheetName = "UserData";
		int rowCount = data.getRowCount(sheetName);

		for (int rowNum = 2; rowNum <= rowCount - 3; rowNum++) {
			String emailID = data.getCellData(sheetName, "Email", rowNum);

			emailTextbox.clear();
			emailTextbox.sendKeys(emailID);
			nextButton.click();

			Thread.sleep(1000);

			String errorMsg = loginError.getText();

			if ((errorMsg.equals("Couldn’t find your Google Account"))
					|| (errorMsg.equals("Enter a valid email or phone number"))
					|| (errorMsg.equals("Enter an email or phone number"))) {
				System.out.println("Email ID : " + emailID + " -->" + "'" + errorMsg + "'"
						+ " :error messsage fetch it correctly");
			} else {
				System.out.println("Email ID : " + emailID + " -->" + "  :error messsage is not fetch it correctly");
			}

		}

	}

	@Rule
	public ErrorCollector errCol = new ErrorCollector();

	// TC_Login_008 -->logging into the Application with valid credential
	
	public void validEmail() throws InterruptedException {
		emailTextbox.sendKeys(userEmail);
		nextButton.click();
		Thread.sleep(1000);
		if (nextButton.isDisplayed()) {
			System.out.println("TC_Login_008 - Login button is displayed successfully");
		}

		else {
			System.out.println("TC_Login_008 - Login button is not displayed");
		}
		Thread.sleep(1000);

	}

	// TC_Login_009 -->logging into the Application with empty password box
	
	public void emptyPassword() throws InterruptedException {
		emailTextbox.sendKeys(userEmail);
		Thread.sleep(2000);
		nextButton.click();
		Thread.sleep(3000);
		loginButton.click();
		Thread.sleep(2000);

		String actualMsg = passwordError.getText();
		String expectedMsg = "Enter a password";

		try {
			Assert.assertEquals(actualMsg, expectedMsg);
		} catch (Throwable error) {
			errCol.addError(error);
			System.out.println(error);

		}

	}

	// TC_Login_010 -->logging into the Application with wrong password
	
	public void wrongPassword() throws InterruptedException {
		emailTextbox.sendKeys(userEmail);
		Thread.sleep(2000);
		nextButton.click();
		Thread.sleep(3000);
		passwdTextbox.sendKeys(emptyPassword);
		loginButton.click();
		Thread.sleep(2000);

		String actualMsg = wrongPasswordError.getText();
		String expectedMsg = "Wrong password. Try again or click Forgot password to reset it.";

		try {
			Assert.assertEquals(actualMsg, expectedMsg);
		} catch (Throwable error) {
			errCol.addError(error);
			System.out.println(error);

		}

	}

	// TC_Login_011 -->logging into the Application with valid Credentials
	
	public void validCredentials() throws InterruptedException {
		emailTextbox.sendKeys(userEmail);
		Thread.sleep(2000);
		nextButton.click();
		Thread.sleep(3000);
		passwdTextbox.sendKeys(userPassword);
		loginButton.click();
		Thread.sleep(2000);
	}
}
