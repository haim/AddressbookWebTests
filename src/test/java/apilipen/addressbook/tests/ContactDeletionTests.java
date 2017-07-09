package apilipen.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
	
	
	
	
  @Test
  public void  contactDeletionTest() {
	  app.getNavigationHelper().gotoHomePage(); 	  
	  app.getContactsHelper().selectContact();	  
	  app.getContactsHelper().submitDeletionContuct();
	  app.getNavigationHelper().gotoHomePage(); 
	  
	  
  }
}
