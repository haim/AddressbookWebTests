package apilipen.addressbook.tests;
import java.util.List;

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
    @Test
    public void GroupDeletionTests2() {
    
    	  
  		List <GroupData> before = app.group().list() ;
  		int index = before.size() - 1;
  		app.group().delete(index);
    	List <GroupData>  after = app.group().list();
    	Assert.assertEquals(after.size()  ,before.size() - 1);
         
        before.remove(index);
        Assert.assertEquals(before, after);
          
    
    }


  
} // End of class
