package apilipen.addressbook.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import apilipen.addressbook.model.GroupData;

public class GroupModificationTests  extends TestBase {
	
	
	
	
	
	
  @Test
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
  


}
