package apilipen.addressbook.tests;

import org.testng.annotations.Test;

import apilipen.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{
	
	
	
	
	
  @Test (enabled = false)
  public void testContactModification() {
	 // app.getNavigationHelper().gotoHomePage();  
	  
	  
	  if (! app.getContactsHelper().isThereAContact()) {
	  app.goTo().gotoContactPage(); 
	  app.getContactsHelper().createContact(new ContactData("Winny", "Pooh", 
			  "1223 Sonate way MV, CA 94040", "9663457889", "sokolsky@list.ru", "testB"), true );
  }
	  

	  
	  app.getContactsHelper().initUpdateContuct();
	  app.getContactsHelper()
	  		.fillContactCreation(new ContactData("Sara", "Moore", "1223, Ednamary way MV, CA 94040", "9663457889", "sokolsky@list.ru" , null ), false );  	
	  app.getContactsHelper(). 	submitContactDeleation();
	  app.goTo().gotoHomePage(); 
  }
}
