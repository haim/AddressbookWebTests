package apilipen.addressbook.tests;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import apilipen.addressbook.model.GroupData;

public class GroupModificationTests  extends TestBase {
	
	@BeforeMethod
	public void ensurePreconditions (){
		 app.goTo().groupPage();  
		  
		  if (app.group().list().size() == 0) {
			  app.group().create(new GroupData()
					  .withName("test3")
					  .withHeader("test3")
					  .withFooter("test3"));
		  }
	}
	
  
  
  @Test  (enabled = false)
  public void testGroupModification() {
	  
	  
	  List <GroupData> before = app.group().list() ;
	  int index = before.size() - 1;
	  GroupData newGroup = new GroupData()
			  .withId( before.get(index).getId() )
			  .withName("testM")
			  .withHeader("testM")
			  .withFooter("testM");

		
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

  @Test   
  public void testGroupModification2() {
  
	  Set <GroupData> before = app.group().allGroupslist() ;
	  GroupData modifiedGroup = before.iterator().next();
	
	  GroupData newGroup = new GroupData()
			  .withId( modifiedGroup.getId())
			  .withName("testSS")
			  .withHeader("testSS")
			  .withFooter("testSS");

		
	  app.group().modify( newGroup);	  
	  Set <GroupData>  after = app.group().allGroupslist();
      Assert.assertEquals(after.size()  , before.size());
      
    
	  before.remove(modifiedGroup);
	  before.add(newGroup);  
	 
	   Assert.assertEquals( before,    after);
	  
  }
  
  
}
