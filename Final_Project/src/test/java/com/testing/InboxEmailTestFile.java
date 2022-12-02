package com.testing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InboxEmailTestFile {
	
	InboxEmailPageFile EmailPg = new InboxEmailPageFile();
	
	  @BeforeClass
	  public void openBrowser() throws Exception {
		  EmailPg.openBrowser();
		  EmailPg.openURL();
	  }
	  
	  @AfterClass
	  public void closeBrowser() throws Exception {
	      EmailPg.closeBrowser();
	  }
	   	  
	  @Test  (priority = 0)
	  public void TC_Inbox_001() throws InterruptedException   {
	      EmailPg.totalEmailFirstPg();
	  }
	  
	  @Test  (priority = 1)
	  public void TC_Inbox_002()  {
	      EmailPg.totalEmailInbox();
	  }
	  
}
