package com.testing;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class TrashEmailPageFile extends LocatorsFile {

	public WebDriver driver;

	public void openBrowser() throws IOException, InterruptedException {

		// Opening Chrome Browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Mansi\\eclipse-workspace\\Final_Project\\Project_Data\\chromedriver.exe");
		Thread.sleep(1000);
		driver = new ChromeDriver();
		Thread.sleep(1000);
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
		Thread.sleep(2000);
		driver.quit(); // closing URL
	}
 
	/* TC_Trash_001 --> Email selected, counting total number of Emails and selected email moving into Trash*/
	
	public void emailTrash() throws InterruptedException {
		System.out.println("-------------- TC_Trash_001 : Selected email moving into back into Trash -------------");
		Thread.sleep(2000);
		emailCheckBox.click();
		
		String totalEmailBefore = totalEmailsBefore.getText();
		System.out.println("Total number of emails in the inbox: " + totalEmailBefore);
		boolean check = emailCheckBox.isSelected();
		System.out.println(!check + ": Email selected to move in Trash");
		Thread.sleep(2000);
		moveToButton.click();

		WebElement trashBtn = moveToButton.findElement(By.xpath("(//div[contains(@class,'J-N-Jz')])[14]"));
		trashBtn.click();
		Thread.sleep(2000);
		
		String movingAfterTrash = totalEmailsBefore.getText();
		System.out.println("Total number of emails in the inbox after moving into trash: " + movingAfterTrash);

	}

	/* TC_Trash_002 --> Email selected to moved back from Trash to Inbox and counting total number of Emails */
	
	public void emailBack() throws InterruptedException {
        System.out.println("-------------- TC_Trash_002 : Email moved back into the Inbox ---------------");
        Thread.sleep(2000);
		moreButton.click();
		trashLinK.click();

		Actions act = new Actions(driver);
		act.contextClick(trashEmailselect).perform();
		inboxLink.click();
		backToInbox.click();
		Thread.sleep(2000);
		String totalEmailAfter = totalEmailsBefore.getText();
		Thread.sleep(1000);
		System.out.println("Total number of emails in the inbox after email move back into Inbox: " + totalEmailAfter);
	}
}
