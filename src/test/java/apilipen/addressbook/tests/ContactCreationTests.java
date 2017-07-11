package apilipen.addressbook.tests;
import org.testng.annotations.Test;

import apilipen.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  
    
    @Test(enabled = false)
    public void testContactCreation() {

    	  app.goTo().gotoContactPage();   	
    	  app.getContactsHelper(). 	fillContactCreation(new ContactData("Winny", "Pooh", 
    			  "1223 Sonate way MV, CA 94040", "9663457889", "sokolsky@list.ru", "testB"), true );  	
    	  app.getContactsHelper(). 	submitContactCreation();
    	
 
    }
    
  
    
}
