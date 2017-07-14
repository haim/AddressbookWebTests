package apilipen.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import apilipen.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  
    
    @Test(enabled = true)
    public void testContactCreation() {

//  1. variable "before" "after"  containce integer:    int before = app.contact().countContacts();
//						  create new method :   .countContacts();
//  2.variable "before", "after"  replaced with List of contacts as objects: List<ContactData> before = app.contact().getContactList();
//                         create new method : .getContactList();

		List<ContactData> before = app.contact().getContactList();

				  app.goTo().gotoContactPage();
				  app.contact(). 	fillContactCreation(new ContactData("Norma", "Kale",
						  "1223 Sonate way MV, CA 94040", "9663457889", "sokolsky@list.ru", "testR"), true );
				  app.contact(). 	submitContactCreation();

		List<ContactData>  after =  app.contact().getContactList();

			Assert.assertEquals(after.size(), before.size() + 1);
 
    }
    
  
    
}
