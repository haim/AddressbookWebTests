package apilipen.addressbook.tests;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import apilipen.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {
    

    
    @Test(enabled = false)
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
 
    
   // "Comparesing whole Lists of groups before and after deletion" 
    @Test
    public void GroupDeletionTests2() {
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
          
          before.remove(before.size()-1); // removing from old List deleted element
          // compare in each elements in Lists
          
      // but, we can do  :
//                   for (int i = 0 ; i < after.size() ; i ++ ) {
//        	       Assert.assertEquals(before.get(i), after.get(i));
//          			}
    
          Assert.assertEquals(before, after);
          
    
    } 
  
} // End of class
