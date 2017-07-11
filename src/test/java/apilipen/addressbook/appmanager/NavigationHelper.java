package apilipen.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

	
	public NavigationHelper(WebDriver wd){
		
	
		 super(wd);
	}
	
	
	
	public void groupPage() {
		
		if (isElementPresent(By.tagName("h1"))
			   && driver.findElement(By.tagName("h1")).getText().equals("Groups")
			     && isElementPresent(By.name("new"))) {
			return;
		}	
		clickElement(By.linkText("groups"));
	}

	
	
	public void gotoHomePage() {
		if (isElementPresent(By.id ("maintable"))) {  
				return;
			}
		 clickElement(By.xpath("//a[contains(.,'home')]"));

	}
	
	
	public void gotoContactPage() {
		clickElement(By.linkText("add new"));
	}
	
}
