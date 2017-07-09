package apilipen.addressbook.tests;

import org.testng.annotations.Test;

import apilipen.addressbook.model.GroupData;

public class GroupModificationTests  extends TestBase {
	
	
	
	
	
	
  @Test
  public void testGroupModification() {
	  
	  app.getNavigationHelper().gotoGroupPage();  
	  if (! app.getGroupHelper().isThereAGroup()) {
		  app.getGroupHelper().createGroup(new GroupData("test3", "test3", "testC3"));
	  }
	  
	  app.  getGroupHelper().selectGroup();  
	  app.  getGroupHelper().initGroupModification();
	  app. getGroupHelper().  fillGroupForm(new GroupData("testB", "testB", "testB"));
	  app.getGroupHelper().submitGroupModification();
	  app. getGroupHelper().  returnToGroupPage();
	  
  }
  


}
