package apilipen.addressbook.tests;

import org.testng.annotations.Test;

import apilipen.addressbook.model.GroupData;

public class GroupCreationTests  extends TestBase {
	
	
	
	
	   @Test
	    public void testGroupCreation() {
		 
		   app.  gotoGroupPage();
		   app.   initGropCreation();
		   app.   fillGroupForm(new GroupData("test1", "test2", "test3"));
		   app.   submitGroupCreation();
		   app.   returnToGroupPage();
	    }
	  
	  
}
