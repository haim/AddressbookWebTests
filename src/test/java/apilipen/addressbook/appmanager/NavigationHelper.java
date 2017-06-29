package apilipen.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

	

	
	
	public NavigationHelper(WebDriver wd){
		
		//this.driver = wd;
		 super(wd);
	}
	
	
	
	public void gotoGroupPage() {
		clickElement(By.linkText("groups"));
	}

}
