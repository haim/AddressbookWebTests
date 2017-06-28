package apilipen.addressbook.tests;

import org.testng.annotations.Test;

import apilipen.addressbook.model.GroupData;

public class GroupCreationTests  extends TestBase {
	
	
	
	
	   @Test
	    public void testGroupCreation() {
		 
		   app.getNavigationHelper().gotoGroupPage();  
		   app. getGroupHelper().  initGropCreation();
		   app. getGroupHelper().  fillGroupForm(new GroupData("test1", "test2", "test3"));
		   app. getGroupHelper().  submitGroupCreation();
		   app. getGroupHelper().  returnToGroupPage();
	    }
	  
	  
}
