package apilipen.addressbook.tests;
import java.util.List;
import java.util.Set;

import apilipen.addressbook.model.Groups;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import apilipen.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertEquals;

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

    @Test (enabled = false)
    public void GroupDeletionTests3() {
		Set <GroupData> before = app.group().allGroupslist() ;
		GroupData deletedGroup = before.iterator().next();

		app.group().delete(deletedGroup);
		Set <GroupData>  after = app.group().allGroupslist();
		Assert.assertEquals(after.size()  ,before.size() - 1);

		before.remove(deletedGroup);
		Assert.assertEquals(before, after);


    }


/*
    Heshing - предварительная проверка  при помощи более быстрой операции:
       проверка количества, до загрузки списка групп

 */
	@Test
	public void GroupDeletionTests_v5_6() {
		Groups before = app.group().all() ;
		GroupData deletedGroup = before.iterator().next();

		app.group().delete(deletedGroup);
		assertEquals(app.group().сount() ,before.size() - 1);
		Groups  after = app.group().all();
		assertThat(after, equalTo(before.without(deletedGroup)));

	}
  
} // End of class
