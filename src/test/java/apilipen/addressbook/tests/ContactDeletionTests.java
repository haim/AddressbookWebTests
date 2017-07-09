package apilipen.addressbook.tests;

import org.testng.annotations.Test;

import apilipen.addressbook.model.ContactData;
import apilipen.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase {
	
	
	
	
  @Test
  public void  contactDeletionTest() {
	  app.getNavigationHelper().gotoHomePage(); 
	  
	  if (! app.getContactsHelper().isThereAContact()) {
		  app.getNavigationHelper().gotoContactPage(); 
		  app.getContactsHelper().createContact(new ContactData("Winny", "Pooh", 
    			  "1223 Sonate way MV, CA 94040", "9663457889", "sokolsky@list.ru", "testB"), true );
	  }
	  
	  app.getContactsHelper().selectContact();	  
	  app.getContactsHelper().submitDeletionContuct();
	  app.getNavigationHelper().gotoHomePage(); 
	  
	  
  }
}
