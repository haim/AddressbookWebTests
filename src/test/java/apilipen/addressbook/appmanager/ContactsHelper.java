package apilipen.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import apilipen.addressbook.model.ContactData;

public class ContactsHelper extends HelperBase {



	public ContactsHelper(WebDriver wd) {
		//this.driver = wd;
		 super(wd);
	}

	public void fillContactCreation(ContactData contactData) {
		setText(By.name("firstname" ), contactData.getFname());
		setText(By.name("home" ), contactData.getLname());
		setText(By.name("home" ), contactData.getAddr());
		setText(By.name("home" ), contactData.getPhone());
		setText(By.name("email" ), contactData.getEmail());

	}

	public void submitContactCreation() {
        clickElement(By.xpath("//div[@id='content']/form/input[21]"));
	}

	public void gotoContactPage() {
		clickElement(By.linkText("add new"));
	}
	
	

}
