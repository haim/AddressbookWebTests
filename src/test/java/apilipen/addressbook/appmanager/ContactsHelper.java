package apilipen.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import apilipen.addressbook.model.ContactData;

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



//	public void gotoHomePage() {
//		
//		
//	}

	public void selectContact() {
		clickElement(By.name("selected[]" ));
		
	}

	public void submitDeletionContuct() {
		clickElement(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
		submitAlertPopUp();
		
	}

	public void initUpdateContuct() {
	//	clickElement(By.xpath("//*[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
		//.//*[@id='maintable']/tbody/tr[2]/td[8]/a/img        "//img[@title='Edit']"
		clickElement(By.xpath("//a/img[@title=\"Edit\"]"));
	}

	public void submitContactDeleation() {
		// TODO Auto-generated method stub
		clickElement(By.name("update"));
	}


	
	

}
