package apilipen.addressbook.tests;
import org.testng.annotations.Test;

import apilipen.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  
    
    @Test
    public void testContactCreation() {

    	  app.getContactsHelper().gotoContactPage(); 	    	
    	  app.getContactsHelper(). 	fillContactCreation(new ContactData("Sara", "Bernar", "1223, Ednamary way MV, CA 94040", "9663457889", "sokolsky@list.ru") );  	
    	  app.getContactsHelper(). 	submitContactCreation();
    }
    
  
    
}
