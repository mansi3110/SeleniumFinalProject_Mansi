package com.testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocatorsFile {
	 /*-------------------------COMMON LOCATORS FOR ALL FILES ---------------------*/
		@FindBy (name = "identifier") public WebElement emailTextbox;
		@FindBy (id = "identifierNext") public WebElement nextButton;
		@FindBy (name = "Passwd") public WebElement passwdTextbox;
		@FindBy (id = "passwordNext") public WebElement loginButton;
		
		
	 /*--------------------------- LOGIN LOCATORS ---------------------------*/
		@FindBy (xpath = "(//div[contains(@class, 'LXRPh')])[1]/div[2]") public WebElement loginError;
		@FindBy (xpath = "//span[starts-with(text(),'Enter a password')]") public WebElement passwordError;
		@FindBy (xpath = "//span[starts-with(text(),'Wrong password.')]") public WebElement wrongPasswordError;
		
		
	 /*--------------------------- INBOX EMAIL LOCATORS ---------------------------*/	
		@FindBy (xpath ="(//span[contains(@class, 'ts')])[2]") public WebElement emailFirstPage;
		@FindBy (xpath ="(//span[contains(@class, 'ts')])[3]") public WebElement totalEmails; 
		
		
	 /*--------------------------- TRASH EMAIL LOCATORS ---------------------------*/	
		
		
	    @FindBy (xpath = "(//div[@class='Cp'])[1]/div/table/tbody/tr[1]/descendant::div[1]") public WebElement emailCheckBox;
		@FindBy (xpath = "(//div[contains(@role,'button')])[17]/div[1]") public WebElement moveToButton;
		@FindBy (xpath ="(//span[contains(@class, 'ts')])[3]") public WebElement totalEmailsBefore; 
		//@FindBy (xpath = "(//span[contains(@class, 'ts')])[6]") public WebElement totalEmailsAfter;
		@FindBy (xpath = "(//span[contains(@class, 'CJ')])[1]") public WebElement moreButton;
		@FindBy (xpath = "(//span[contains(@class, 'nU')])[6]") public WebElement trashLinK;
		@FindBy (xpath = "//div[starts-with(text(),'Messages')]/parent::div/following-sibling::div/div[1]/div/table/tbody/tr[1]") public WebElement trashEmailselect;
		
	 /*--------------------------- READ/UNREAD EMAIL LOCATORS ---------------------------*/		
		
		@FindBy (xpath = "(//div[starts-with(text(),'Move to inbox')])[2]") public WebElement inboxLink;
		@FindBy (xpath = "(//span[contains(@class, 'nU')])[1]") public WebElement backToInbox;
	    @FindBy (xpath = "//span[starts-with(text(),'Conversation marked as read.')]") public WebElement readAlert;
	    @FindBy (xpath = "//span[starts-with(text(),'Conversation marked as unread.')]") public WebElement unreadAlert;
	    @FindBy (xpath = "(//div[contains(@role,'button')])[20]") public WebElement moreOptionRead;
	    @FindBy (xpath = "(//div[contains(@class,'asa')])[11]") public WebElement moreOptionUnread;
	    @FindBy (xpath = " //div[starts-with(text(),'Mark as read')]") public WebElement readButton;
	    @FindBy (xpath = " //div[starts-with(text(),'Mark as unread')]") public WebElement unreadButton;
	    
		
}
