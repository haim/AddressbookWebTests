package apilipen.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import apilipen.addressbook.model.ContactData;

public class ContactsHelper {

	private WebDriver driver;

	public ContactsHelper(WebDriver wd) {
		this.driver = wd;
	}

	public void fillContactCreation(ContactData contactData) {
		driver.findElement(By.name("firstname")).click();
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(contactData.getFname());
		driver.findElement(By.name("lastname")).click();
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(contactData.getLname());
		driver.findElement(By.name("address")).click();
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys(contactData.getAddr());
		driver.findElement(By.name("home")).click();
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys(contactData.getPhone());
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
	}

	public void submitContactCreation() {
		driver.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
	}

	public void gotoContactPage() {
		driver.findElement(By.linkText("add new")).click();
	}
	
	

}
