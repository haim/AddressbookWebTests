package apilipen.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import apilipen.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {
    

    
    @Test
    public void GroupDeletionTests() {
    	  app.getNavigationHelper().gotoGroupPage();  
    	  int before = app.getGroupHelper().getGroupCount(); 
    	  if (! app.getGroupHelper().isThereAGroup()) {
    		  app.getGroupHelper().createGroup(new GroupData("testC", "testC", "testC"));
    	  }
    	  app.  getGroupHelper().selectGroup(before - 2);  
    	  app.  getGroupHelper().deleteSelectedGroup();
    	  app.  getGroupHelper().returnToGroupPage();
    	  int after = app.getGroupHelper().getGroupCount();
    	  
          Assert.assertEquals(after  , before -1);
    }
    
  
}
