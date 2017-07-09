package apilipen.addressbook.tests;
import org.testng.annotations.Test;

import apilipen.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  
    
    @Test
    public void testContactCreation() {

    	  app.getNavigationHelper().gotoContactPage();   	
    	  app.getContactsHelper(). 	fillContactCreation(new ContactData("Winny", "Pooh", 
    			  "1223 Sonate way MV, CA 94040", "9663457889", "sokolsky@list.ru", "test3"), true );  	
    	  app.getContactsHelper(). 	submitContactCreation();
    	
    	  //  name="update"
    }
    
  
    
}
