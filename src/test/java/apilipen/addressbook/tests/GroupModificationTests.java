package apilipen.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import apilipen.addressbook.model.GroupData;

public class GroupModificationTests  extends TestBase {
	
	
	
	
	
	
  @Test
  public void testGroupModification() {
	  
	  app.getNavigationHelper().gotoGroupPage();  
	   int before = app.getGroupHelper().getGroupCount(); 
	  if (! app.getGroupHelper().isThereAGroup()) {
		  app.getGroupHelper().createGroup(new GroupData("test3", "test3", "testC3"));
	  }
	  
	  app.  getGroupHelper().selectGroup(before - 1);  
	  app.  getGroupHelper().initGroupModification();
	  app. getGroupHelper().  fillGroupForm(new GroupData("testMU", "testMU", "testMU"));
	  app.getGroupHelper().submitGroupModification();
	  app. getGroupHelper().  returnToGroupPage();
	  
	  int after = app.getGroupHelper().getGroupCount();
      Assert.assertEquals(after  , before);
  
	  
  }
  


}
