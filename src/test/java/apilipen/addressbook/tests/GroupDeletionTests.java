package apilipen.addressbook.tests;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import apilipen.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {
    

    
    @Test
    public void GroupDeletionTests() {
    	  app.getNavigationHelper().gotoGroupPage();  
    
    	  if (! app.getGroupHelper().isThereAGroup()) {
    		  app.getGroupHelper().createGroup(new GroupData("testC", "testC", "testC"));
    	  }
    	  
  		List <GroupData> before = app.getGroupHelper().getGroupList() ;
    	  app.  getGroupHelper().selectGroup(before.size() - 1);  
    	  app.  getGroupHelper().deleteSelectedGroup();
    	  app.  getGroupHelper().returnToGroupPage();
    	  List <GroupData>  after = app.getGroupHelper().getGroupList();
    	  
          Assert.assertEquals(after.size()  , before.size()-1);
    }
    
  
}
