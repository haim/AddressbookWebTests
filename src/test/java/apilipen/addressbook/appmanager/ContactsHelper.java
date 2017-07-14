package apilipen.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import apilipen.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactsHelper extends HelperBase {



	public ContactsHelper(WebDriver wd) {
		//this.driver = wd;
		 super(wd);
	}

	public void fillContactCreation(ContactData contactData, boolean creation) {
		
		setText(By.name("firstname" ), contactData.getFname());
		setText(By.name("lastname" ), contactData.getLname());
		setText(By.name("address" ), contactData.getAddr());
		setText(By.name("home" ), contactData.getPhone());
		setText(By.name("email" ), contactData.getEmail());
		
		if (creation){
			new  Select (driver.findElement (By.name("new_group"))).selectByVisibleText(contactData.getGroup());
			
		} else {
			Assert.assertFalse(isElementPresent (By.name("new_group")));
		}
	

	}

	public void submitContactCreation() {
        clickElement(By.xpath("//div[@id='content']/form/input[21]"));
	}




	public void selectContact( int index) {

		findWebElements(By.name("selected[]")).get(index).click();
	//	это можно перенести в базовый класс как clickSelectedElementFromList
		
	}

	public void submitDeletionContuct() {
		clickElement(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
		submitAlertPopUp();
		
	}

	public void initUpdateContuct(int index) {
		findWebElements(By.xpath("//a/img[@title=\"Edit\"]")).get(index).click();
		//clickElement(By.xpath("//a/img[@title=\"Edit\"]"));
	}

	public void submitContactDeleation() {
		clickElement(By.name("update"));
	}

	public void createContact(ContactData contactData, boolean b) {	
		
  	  fillContactCreation(contactData, b );  	
  	  submitContactCreation();
		
	}

	public boolean isThereAContact() {
		// TODO Auto-generated method stub
		return isElementPresent(By.name("selected[]"));
	}


	public int countContacts() {

		return  driver.findElements(By.name("selected[]")).size();
	}

	public List<ContactData> getContactList() {

		//Create list of object - contacts on the page
List <ContactData> contacts = new ArrayList<ContactData>();
		// Create list of WebElements by locator
List <WebElement> elements = driver.findElements(By.name("entry")); // find parent element
		for (WebElement element : elements) {

			String lasttname = element.findElement(By.xpath("//td[2]")).getText();
			String firstname = element.findElement(By.xpath("//td[3]")).getText();

// Create object of ContactData type
			ContactData contact = new ContactData(firstname, lasttname, null, null, null, null);

			contacts.add(contact);
		}
  return contacts;
	}
}
