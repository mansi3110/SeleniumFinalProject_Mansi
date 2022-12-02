package com.testing;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class ReadUnreadEmailPageFile extends LocatorsFile {
	public WebDriver driver;

	public void openBrowser() throws IOException, InterruptedException {

		// Opening Chrome Browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mansi\\eclipse-workspace\\Final_Project\\Project_Data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		// Setup Driver Property
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}

	public void openURL() throws Exception {
		driver.get("https://mail.google.com/mail/"); // opening any URL
		emailTextbox.sendKeys("dummytest112345@gmail.com");
		nextButton.click();
		passwdTextbox.sendKeys("Dummy@123456");
		loginButton.click();
		Thread.sleep(7000);
	}

	public void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit(); // closing URL
	}
	
 /* RU_Check_001 --> Email marked as read */
	public void ReadToUnread() throws InterruptedException {
		emailCheckBox.click();
		moreOptionRead.click();
		readButton.click();
		System.out.println("Email marked as a Read : "+readAlert.getText());
		Thread.sleep(1000);
		emailCheckBox.click();
	}
	
 /* RU_Check_002 --> Email marked as Unread */
	public void UnreadToRead() throws InterruptedException {
		Thread.sleep(1000);
		emailCheckBox.click();
		moreOptionUnread.click();
		unreadButton.click();
		System.out.println("Email marked as an Unread : "+unreadAlert.getText());
		
	}

}
