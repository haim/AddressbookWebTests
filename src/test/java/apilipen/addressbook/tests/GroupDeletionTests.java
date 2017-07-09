package apilipen.addressbook.tests;
import org.testng.annotations.Test;

import apilipen.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {
    

    
    @Test
    public void GroupDeletionTests() {
    	  app.getNavigationHelper().gotoGroupPage();  
    	  
    	  if (! app.getGroupHelper().isThereAGroup()) {
    		  app.getGroupHelper().createGroup(new GroupData("testC", "testC", "testC"));
    	  }
    	  app.  getGroupHelper().selectGroup();  
    	  app.  getGroupHelper().deleteSelectedGroup();
    	  app.  getGroupHelper().returnToGroupPage();
    }
    
  
}
