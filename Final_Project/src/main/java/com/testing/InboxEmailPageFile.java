package com.testing;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class InboxEmailPageFile extends LocatorsFile {

	public WebDriver driver;

	public void openBrowser() throws IOException, InterruptedException {

		// Opening Chrome Browser
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mansi\\eclipse-workspace\\Final_Project\\Project_Data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		// Setup Driver Property
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}

	public void openURL() throws Exception {
		driver.get("https://mail.google.com/mail/"); // opening any URL
		emailTextbox.sendKeys("dummytest112345@gmail.com");
		nextButton.click();
		passwdTextbox.sendKeys("Dummy@123456");
		loginButton.click();
	}

	public void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit(); // closing URL
	}

	/* TC_Inbox_001 --> Total number of Emails in first page */
	
	public void totalEmailFirstPg() throws InterruptedException {

		String totalEmail = emailFirstPage.getText();
		System.out.println("Number of Emails in first page: " + totalEmail);

	}
	
	/* TC_Inbox_002 --> Total number of Emails in Inbox */

	public void totalEmailInbox() {

		String totalEmailInbox = totalEmails.getText();
		System.out.println("Total number of Emails in Inbox: " + totalEmailInbox);

	}

}
