package apilipen.addressbook.tests;

import org.testng.annotations.Test;

import apilipen.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{
	
	
	
	
	
  @Test
  public void testContactModification() {
	 // app.getNavigationHelper().gotoHomePage(); 
	  app.getContactsHelper().initUpdateContuct();
	  app.getContactsHelper()
	  		.fillContactCreation(new ContactData("Sara", "Moore", "1223, Ednamary way MV, CA 94040", "9663457889", "sokolsky@list.ru" , null ), false );  	
	  app.getContactsHelper(). 	submitContactDeleation();
	  app.getNavigationHelper().gotoHomePage(); 
  }
}
