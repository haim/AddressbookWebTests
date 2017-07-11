package apilipen.addressbook.tests;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import apilipen.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {
    
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
 
	
	
    @Test(enabled = false)
    public void GroupDeletionTests() {
    	
 	List <GroupData> before = app.group().list() ;
  		int index = before.size() - 1;
  		app.  group().  delete(index);
    	  List <GroupData>  after = app.group().list();
    	  
          Assert.assertEquals(after.size()  , index);
    }
 
    
   // "Comparesing whole Lists of groups before and after deletion" 
    @Test(enabled = false)
    public void GroupDeletionTests2() {
    
    	  
  		List <GroupData> before = app.group().list() ;
  		int index = before.size() - 1;
  		app.group().delete(index);
    	List <GroupData>  after = app.group().list();
    	Assert.assertEquals(after.size()  ,before.size() - 1);
         
        before.remove(index);
        Assert.assertEquals(before, after);
          
    
    }

    @Test
    public void GroupDeletionTests3() {  
  		Set <GroupData> before = app.group().allGroupslist() ;
  		GroupData deletedGroup = before.iterator().next();
  	
  		app.group().delete(deletedGroup);
  		Set <GroupData>  after = app.group().allGroupslist();
    	Assert.assertEquals(after.size()  ,before.size() - 1);
         
        before.remove(deletedGroup);
        Assert.assertEquals(before, after);
          
    
    }

  
} // End of class
