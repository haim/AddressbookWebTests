package apilipen.addressbook.tests;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import apilipen.addressbook.model.GroupData;

public class GroupModificationTests  extends TestBase {
	
	@BeforeMethod
	public void ensurePreconditions (){
		 app.goTo().groupPage();  
		  
		  if (app.group().list().size() == 0) {
			  app.group().create(new GroupData("test3", "test3", "testC3"));
		  }
	}
	
	
	
	
  @Test (enabled = false)
  public void testGroupModification() {
	  
	 
		List <GroupData> before = app.group().list() ; //	 with new method getGroupList()  

	  app.  group().selectGroup(before.size() - 1);  
	  app.  group().initGroupModification();
	  app. group().  fillGroupForm(new GroupData("testQA", "testQA","testQA"));
	  app.group().submitGroupModification();
	  app. group().  returnToGroupPage();
	  
	  List <GroupData>  after = app.group().list();
      Assert.assertEquals(after.size()  , before.size());
  
	  
  }
  
  @Test (enabled = false)
  public void testGroupModification2() {
	  
	 
	  //  Modifacation test to compare Lists with different order of elements (after modification groups)
		List <GroupData> before = app.group().list() ; //	 with new method getGroupList()  

	  app.  group().selectGroup(before.size() - 1);  
	  app.  group().initGroupModification();
	  
	  GroupData newGroup = new GroupData(before.get(before.size() - 1).getId(),"testA", "testA","testA");
	  
	  app. group().  fillGroupForm (newGroup);
	  app.group().submitGroupModification();
	  app. group().  returnToGroupPage();
	  
	  List <GroupData>  after = app.group().list();
      Assert.assertEquals(after.size()  , before.size());
  
      // delete old group
	  before.remove(before.size() - 1);
	  // aadd new group to old List
	  before.add(newGroup);   // now old List and new should be equal
	  // but they have different order of groups. Use unordered Collection
	   Assert.assertEquals( new HashSet<Object>(before),    new HashSet<Object>(after));
	  
  }

  
  
  @Test
  public void testGroupModification3() {
	  
	  
	  List <GroupData> before = app.group().list() ;
	  int index = before.size() - 1;
	  GroupData newGroup = new GroupData(before.get(index).getId(),"testA", "testA","testA"); 
	  app.group().modify(index, newGroup);	  
	  List <GroupData>  after = app.group().list();
      Assert.assertEquals(after.size()  , before.size());
      
      // delete old group
	  before.remove(index);
	  // aadd new group to old List
	  before.add(newGroup);   // now old List and new should be equal
	  // but they have different order of groups. Use unordered Collection 
	  Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
	  before.sort(byId );
	  after.sort(byId);
	   Assert.assertEquals( before,    after);
	  
  }


  
  
  
}
