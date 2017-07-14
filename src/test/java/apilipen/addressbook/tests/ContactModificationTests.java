package apilipen.addressbook.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import apilipen.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{
	
	
	
	
	
  @Test (enabled = true)
  public void testContactModification() {
	 // app.getNavigationHelper().gotoHomePage();  
	  
	  
	  if (! app.contact().isThereAContact()) {
	  app.goTo().gotoContactPage(); 
	  app.contact().createContact(new ContactData("Winny", "Pooh",
			  "1223 Sonate way MV, CA 94040", "9663457889", "sokolsky@list.ru", "testB"), true );
  }



		app.goTo().gotoHomePage();
List<ContactData> before = app.contact().getContactList();

	  System.out.println("How many contscts: " + before.size());
	  app.contact().initUpdateContuct( before.size() -1  );   // before
	  app.contact()
	  		.fillContactCreation(new ContactData("Wanky", "Pooh",
	  			  "1223 Sonate way MV, CA 94040", "9663457889", "sokolsky@list.ru" , null ), false );  	
	  app.contact(). 	submitContactDeleation();
	  app.goTo().gotoHomePage();

	  List<ContactData> after = app.contact().getContactList();
	  Assert.assertEquals(after.size(), before.size() );
	  
  }
}
