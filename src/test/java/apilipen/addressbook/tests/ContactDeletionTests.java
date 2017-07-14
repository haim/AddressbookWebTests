package apilipen.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import apilipen.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {
	
	
	
	
  @Test (enabled = false)
  public void  contactDeletionTest1() {


	  app.goTo().gotoHomePage();
 int before = app.contact().countContacts();
	  if (! app.contact().isThereAContact()) {
		  app.goTo().gotoContactPage(); 
		  app.contact().createContact(new ContactData("Anna", "Sokol",
    			  "1223 Sonate way MV, CA 94040", "9663457889", "sokolsky@list.ru", "testB"), true );
	  }
	  app.contact().selectContact(before -1);
	  app.contact().submitDeletionContuct();
	  app.goTo().gotoHomePage();
int after = app.contact().countContacts();
	  Assert.assertEquals(after, before - 1);
	  
	  
  }


	@Test (enabled = true)
	public void  contactDeletionTest() {


		app.goTo().gotoHomePage();
List<ContactData> before = app.contact().getContactList();

		if (! app.contact().isThereAContact()) {
			app.goTo().gotoContactPage();
			app.contact().createContact(new ContactData("Anna", "Sokol",
				"1223 Sonate way MV, CA 94040", "9663457889", "sokolsky@list.ru", "testB"), true );
		}

		app.contact().selectContact(before.size() -2);
		app.contact().submitDeletionContuct();
		app.goTo().gotoHomePage();

List<ContactData> after = app.contact().getContactList();
		Assert.assertEquals(after.size(), before.size() - 1);


	}
}

