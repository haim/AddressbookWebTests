package apilipen.addressbook.tests;

import java.util.HashSet;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import apilipen.addressbook.model.GroupData;

public class GroupModificationTests  extends TestBase {
	
	
	
	
	
	
  @Test (enabled = false)
  public void testGroupModification() {
	  
	  app.getNavigationHelper().gotoGroupPage();  
	  
	  if (! app.getGroupHelper().isThereAGroup()) {
		  app.getGroupHelper().createGroup(new GroupData("test3", "test3", "testC3"));
	  }
		List <GroupData> before = app.getGroupHelper().getGroupList() ; //	 with new method getGroupList()  

	  app.  getGroupHelper().selectGroup(before.size() - 1);  
	  app.  getGroupHelper().initGroupModification();
	  app. getGroupHelper().  fillGroupForm(new GroupData("testQA", "testQA","testQA"));
	  app.getGroupHelper().submitGroupModification();
	  app. getGroupHelper().  returnToGroupPage();
	  
	  List <GroupData>  after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size()  , before.size());
  
	  
  }
  
  @Test
  public void testGroupModification2() {
	  
	  app.getNavigationHelper().gotoGroupPage();  
	  
	  if (! app.getGroupHelper().isThereAGroup()) {
		  app.getGroupHelper().createGroup(new GroupData("test3", "test3", "testC3"));
	  }
	  
	  //  Modifacation test to compare Lists with different order of elements (after modification groups)
		List <GroupData> before = app.getGroupHelper().getGroupList() ; //	 with new method getGroupList()  

	  app.  getGroupHelper().selectGroup(before.size() - 1);  
	  app.  getGroupHelper().initGroupModification();
	  
	  GroupData newGroup = new GroupData(before.get(before.size() - 1).getId(),"testA", "testA","testA");
	  
	  app. getGroupHelper().  fillGroupForm (newGroup);
	  app.getGroupHelper().submitGroupModification();
	  app. getGroupHelper().  returnToGroupPage();
	  
	  List <GroupData>  after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size()  , before.size());
  
      // delete old group
	  before.remove(before.size() - 1);
	  // aadd new group to old List
	  before.add(newGroup);   // now old List and new should be equal
	  // but they have different order of groups. Use unordered Collection
	   Assert.assertEquals( new HashSet<Object>(before),    new HashSet<Object>(after));
	  
  }

}
