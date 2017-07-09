package apilipen.addressbook.tests;

import org.testng.annotations.Test;

import apilipen.addressbook.model.GroupData;

public class GroupCreationTests  extends TestBase {
	
	
	
	
	   @Test
	    public void testGroupCreation() {	 
		   app.getNavigationHelper().gotoGroupPage();  	   
		   app.getGroupHelper().createGroup(new GroupData("testC", "testC", "testC"));

	    }
	  
	  
}
