package apilipen.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import apilipen.addressbook.model.GroupData;

public class GroupCreationTests  extends TestBase {
	
	
	
	
	   @Test
	    public void testGroupCreation() {	
		   app.getNavigationHelper().gotoGroupPage();  	  
		   int before = app.getGroupHelper().getGroupCount(); 	   
		   app.getGroupHelper().createGroup(new GroupData("testC", "testC", "testC"));
		   int after = app.getGroupHelper().getGroupCount();
	        Assert.assertEquals(after -1 , before);
	    
	   }
	  
}
