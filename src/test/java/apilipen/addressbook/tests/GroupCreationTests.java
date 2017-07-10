package apilipen.addressbook.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import apilipen.addressbook.model.GroupData;

public class GroupCreationTests  extends TestBase {
	
	
	
	
	   @Test
	    public void testGroupCreation() {	
		   app.getNavigationHelper().gotoGroupPage();  
		   
		// modifacation "int"   to List:    int before = app.getGroupHelper().getGroupCount(); 	
		List <GroupData> before = app.getGroupHelper().getGroupList() ; //	 with new method getGroupList()  
		   app.getGroupHelper().createGroup(new GroupData("testB", "testB", "testB"));
		   List <GroupData>  after = app.getGroupHelper().getGroupList();
	        Assert.assertEquals(after.size() , before.size() + 1);
	    
	   }
	  
}
